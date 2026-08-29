package edu.bellevue.huskygpt.retrieval;

import edu.bellevue.huskygpt.database.PieceRepository;
import edu.bellevue.huskygpt.llm.QueryIntent;
import edu.bellevue.huskygpt.model.Piece;

import java.sql.SQLException;
import java.util.List;

public class StructuredRetriever {
    private final PieceRepository repository;

    public StructuredRetriever(PieceRepository repository) {
        this.repository = repository;
    }

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
                "Intent must use a different retrieval type." + intent.type()
            );
        };
    }
}
