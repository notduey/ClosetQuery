package dev.notduey.closetquery.retrieval;

import java.sql.SQLException;
import java.util.List;

import dev.notduey.closetquery.database.PieceRepository;
import dev.notduey.closetquery.llm.QueryIntent;
import dev.notduey.closetquery.model.Piece;

 /** Handles structured wardrobe retrieval using predefined SQLite queries.
 *
 * <p>This retriever is used for questions where exact database operations
 * are more reliable than semantic similarity, such as most worn, least worn,
 * recently worn, or category-based lookups.</p>
 *
 * <p>The LLM only selects a supported {@link QueryIntent}; the actual SQL
 * operation is still controlled by Java through {@link PieceRepository}.</p>
 */
public class StructuredRetriever {
    private final PieceRepository repository;

    /**
     * Creates a structured retriever backed by the wardrobe repository.
    *
    * @param repository repository used to run the predefined SQLite queries
    */
    public StructuredRetriever(PieceRepository repository) {
        this.repository = repository;
    }

    /**
     * Executes the structured retrieval operation described by a QueryIntent.
     *
     * <p>The intent type determines which repository query runs, while optional
     * category and limit values are passed through when the operation supports
     * them.</p>
     *
     * <p>Semantic and count-only intents are rejected here because they use
     * different retrieval paths elsewhere in the application.</p>
     *
     * @param intent structured retrieval request
     * @return pieces returned by the matching SQLite query
     * @throws SQLException if the database query fails
     * @throws IllegalArgumentException if the intent belongs to another retrieval path
     */
    public List<Piece> retrieve(QueryIntent intent) throws SQLException {
        return switch (intent.type()) { // switch returns value depending on case
            case MOST_WORN -> repository.getMostWornPieces(
                intent.limit(), intent.category()
            );

            case LEAST_WORN -> repository.getLeastWornPieces(
                intent.limit(), intent.category()
            );

            case NEVER_WORN -> repository.getNeverWornPieces(intent.category());

            case MOST_RECENTLY_WORN -> repository.getMostRecentlyWornPieces(
                intent.limit(), intent.category()
            );

            case LEAST_RECENTLY_WORN -> repository.getLeastRecentlyWornPieces(
                intent.limit(), intent.category()
            );

            case RECENTLY_ADDED -> repository.getRecentlyAddedPieces(
                intent.limit(), intent.category()
            );

            case LIST_CATEGORY -> repository.getPiecesByCategory(intent.category());

            case SEMANTIC, COUNT_CATEGORY -> throw new IllegalArgumentException(
                "Intent must use a different retrieval path." + intent.type()
            );
        };
    }
}
