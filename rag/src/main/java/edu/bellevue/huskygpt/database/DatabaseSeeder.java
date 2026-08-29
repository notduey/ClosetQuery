package edu.bellevue.huskygpt.database;

import edu.bellevue.huskygpt.model.Piece;

/**
 * Populates the database with varied sample wardrobe pieces for testing.
 */
public class DatabaseSeeder {

    public static void seed() {
        PieceRepository repository = new PieceRepository();

        try {
            // Tops
            addExisting(
                    repository,
                    "Stussy",
                    "8-Ball Knit Sweater",
                    "Top",
                    "XS",
                    "Beige",
                    "Cream Ivory",
                    "Fall/Winter",
                    "Special Occasion",
                    "Regular",
                    "Acrylic, Nylon, Wool, Mohair",
                    "Heavy knitted sweater suitable for colder weather; statement graphic makes it better suited to styled casual outfits than active use.",
                    "2026-08-18",
                    8
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "AIRism Cotton Oversized Half Sleeve T-Shirt",
                    "Top",
                    "M",
                    "White",
                    "White",
                    "Spring/Summer",
                    "Everyday",
                    "Oversized",
                    "Cotton, Polyester",
                    "Lightweight breathable everyday T-shirt with a smooth feel; useful for warm weather, layering, and relaxed casual outfits.",
                    "2026-08-26",
                    41
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "HEATTECH Extra Warm Crew Neck T-Shirt",
                    "Top",
                    "M",
                    "Black",
                    "Black",
                    "Fall/Winter",
                    "Everyday",
                    "Slim",
                    "Acrylic, Rayon, Polyester, Spandex",
                    "Thermal base layer designed to retain warmth in cold weather; works well underneath sweaters, jackets, and outdoor winter layers.",
                    "2026-02-11",
                    27
            );

            addExisting(
                    repository,
                    "Hanes",
                    "Beefy-T T-Shirt",
                    "Top",
                    "M",
                    "Gray",
                    "Heather Gray",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton",
                    "Heavyweight basic T-shirt with a durable feel; suitable for frequent casual wear and simple layered outfits.",
                    "2026-08-22",
                    58
            );

            addExisting(
                    repository,
                    "Polo Ralph Lauren",
                    "Custom Slim Fit Mesh Polo Shirt",
                    "Top",
                    "S",
                    "Blue",
                    "Newport Navy",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Cotton",
                    "Breathable pique polo that sits between casual and smart-casual; suitable for warm weather, dinners, and polished daytime outfits.",
                    "2026-08-09",
                    19
            );

            addExisting(
                    repository,
                    "Lacoste",
                    "Original L.12.12 Polo Shirt",
                    "Top",
                    "S",
                    "Green",
                    "Green",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Classic cotton pique polo with a clean sporty appearance; appropriate for warm weather and elevated casual outfits.",
                    "2026-07-28",
                    14
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Capilene Cool Daily Shirt",
                    "Top",
                    "M",
                    "Blue",
                    "Utility Blue",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled Polyester",
                    "Technical moisture-wicking shirt designed for hiking, travel, training, and hot-weather outdoor activity.",
                    "2026-08-24",
                    23
            );

            addExisting(
                    repository,
                    "Arc'teryx",
                    "Cormac Crew Neck Shirt",
                    "Top",
                    "M",
                    "Orange",
                    "Solaris",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Polyester",
                    "Lightweight technical top intended for running and hiking; breathable construction makes it useful for high-output activity in warm weather.",
                    "2026-08-20",
                    12
            );

            addExisting(
                    repository,
                    "Nike",
                    "Nike Pro Dri-FIT Short-Sleeve Fitness Top",
                    "Top",
                    "M",
                    "Black",
                    "Black / White",
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Polyester, Spandex",
                    "Close-fitting moisture-wicking performance shirt for workouts, running, and use as an athletic base layer.",
                    "2026-08-25",
                    34
            );

            addExisting(
                    repository,
                    "Adidas",
                    "Adicolor Classics Trefoil T-Shirt",
                    "Top",
                    "M",
                    "Red",
                    "Better Scarlet",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Casual logo T-shirt with a sporty streetwear feel; easy to pair with denim, shorts, or relaxed athletic outfits.",
                    "2026-07-19",
                    17
            );

            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Chase T-Shirt",
                    "Top",
                    "M",
                    "Brown",
                    "Hamilton Brown",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton",
                    "Durable heavyweight everyday tee with understated branding; suitable for workwear-inspired and casual outfits.",
                    "2026-08-23",
                    31
            );

            addExisting(
                    repository,
                    "Supreme",
                    "Box Logo Tee",
                    "Top",
                    "M",
                    "Purple",
                    "Purple",
                    "Spring/Summer",
                    "Special Occasion",
                    "Regular",
                    "Cotton",
                    "Graphic streetwear T-shirt centered around prominent branding; best suited to statement outfits and casual social settings.",
                    "2026-06-14",
                    9
            );

            addExisting(
                    repository,
                    "Comme des Garçons PLAY",
                    "Heart Logo T-Shirt",
                    "Top",
                    "M",
                    "White",
                    "White / Red Heart",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Minimal cotton T-shirt with recognizable heart branding; works well in simple casual and contemporary outfits.",
                    "2026-08-03",
                    16
            );

            addExisting(
                    repository,
                    "A.P.C.",
                    "Raymond T-Shirt",
                    "Top",
                    "M",
                    "Beige",
                    "Ecru",
                    "Spring/Summer",
                    "Everyday",
                    "Regular",
                    "Cotton",
                    "Minimal neutral T-shirt with a clean silhouette; useful for understated everyday outfits and layering.",
                    "2026-08-17",
                    22
            );

            addExisting(
                    repository,
                    "COS",
                    "Regular-Fit Linen Shirt",
                    "Top",
                    "M",
                    "White",
                    "Off White",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Linen",
                    "Breathable linen button-up suited to hot weather; works for relaxed summer outfits as well as slightly dressier casual occasions.",
                    "2026-08-12",
                    13
            );

            addExisting(
                    repository,
                    "J.Crew",
                    "Secret Wash Cotton Poplin Shirt",
                    "Top",
                    "M",
                    "Blue",
                    "Light Blue",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Soft cotton button-down with a versatile smart-casual appearance; appropriate for work, dinners, and layered everyday outfits.",
                    "2026-08-05",
                    20
            );

            addExisting(
                    repository,
                    "Brooks Brothers",
                    "Original Polo Button-Down Oxford Shirt",
                    "Top",
                    "15.5 / 33",
                    "Pink",
                    "Light Pink",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Cotton",
                    "Classic Oxford button-down appropriate for business casual, dinners, and dressier occasions; substantial fabric also layers well.",
                    "2026-05-30",
                    11
            );

            addExisting(
                    repository,
                    "Charles Tyrwhitt",
                    "Non-Iron Twill Shirt",
                    "Top",
                    "15 / 33",
                    "White",
                    "White",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Cotton",
                    "Structured dress shirt intended for formal and professional outfits; smooth twill fabric works well under tailoring.",
                    "2026-04-18",
                    7
            );

            addExisting(
                    repository,
                    "Levi's",
                    "Barstow Western Denim Shirt",
                    "Top",
                    "M",
                    "Blue",
                    "Medium Wash",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Denim western shirt with a rugged casual appearance; works as either a standalone top or a light overshirt.",
                    "2026-07-02",
                    15
            );

            addExisting(
                    repository,
                    "Pendleton",
                    "Board Shirt",
                    "Top",
                    "M",
                    "Multi",
                    "Blue / Green Plaid",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Wool",
                    "Warm wool button-up suitable for cool weather, layering, and heritage-inspired casual outfits.",
                    "2026-01-27",
                    10
            );

            addExisting(
                    repository,
                    "L.L.Bean",
                    "Scotch Plaid Flannel Shirt",
                    "Top",
                    "M",
                    "Red",
                    "Red Tartan",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Cotton",
                    "Soft warm flannel for cool-weather everyday wear; useful for layering during hiking, camping, and relaxed outdoor activities.",
                    "2026-03-07",
                    25
            );

            addExisting(
                    repository,
                    "The North Face",
                    "Half Dome Pullover Hoodie",
                    "Top",
                    "M",
                    "Gray",
                    "TNF Medium Grey Heather",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Cotton, Polyester",
                    "Warm casual hoodie suited to cool weather, travel, lounging, and outdoor layering when technical performance is not required.",
                    "2026-08-14",
                    29
            );

            addExisting(
                    repository,
                    "Champion",
                    "Reverse Weave Hoodie",
                    "Top",
                    "M",
                    "Yellow",
                    "Gold",
                    "Fall/Winter",
                    "Everyday",
                    "Oversized",
                    "Cotton, Polyester",
                    "Heavyweight fleece hoodie with a relaxed fit; useful for cold casual days, lounging, and streetwear-inspired layering.",
                    "2026-07-11",
                    36
            );

            addExisting(
                    repository,
                    "Fear of God Essentials",
                    "Essentials Pullover Hoodie",
                    "Top",
                    "M",
                    "Brown",
                    "Dark Oatmeal",
                    "Fall/Winter",
                    "Casual",
                    "Oversized",
                    "Cotton, Polyester",
                    "Heavy relaxed hoodie with an intentionally oversized silhouette; designed for neutral streetwear and layered cold-weather outfits.",
                    "2026-06-25",
                    18
            );

            addExisting(
                    repository,
                    "Acne Studios",
                    "Logo Crew Neck Sweatshirt",
                    "Top",
                    "M",
                    "Pink",
                    "Dusty Pink",
                    "Fall/Winter",
                    "Casual",
                    "Oversized",
                    "Cotton",
                    "Soft premium sweatshirt with a relaxed contemporary silhouette; useful as a statement layer during cooler weather.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Stone Island",
                    "Compass Patch Crewneck Sweatshirt",
                    "Top",
                    "M",
                    "Green",
                    "Sage Green",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Midweight sweatshirt with recognizable sleeve badge; suited to elevated casual and technical-inspired streetwear outfits.",
                    "2026-02-22",
                    6
            );

            addExisting(
                    repository,
                    "Maison Kitsune",
                    "Fox Head Patch Classic T-Shirt",
                    "Top",
                    "M",
                    "Orange",
                    "Burnt Orange",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Simple premium T-shirt with small embroidered branding; works well in clean casual and contemporary outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "AMI Paris",
                    "Ami de Coeur T-Shirt",
                    "Top",
                    "M",
                    "Black",
                    "Black / Red",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Minimal designer T-shirt with a small heart logo; useful for understated casual outfits with a slightly elevated feel.",
                    "2026-06-03",
                    5
            );

            addExisting(
                    repository,
                    "Marni",
                    "Logo-Print T-Shirt",
                    "Top",
                    "M",
                    "Multi",
                    "White / Multicolor Graphic",
                    "Spring/Summer",
                    "Special Occasion",
                    "Oversized",
                    "Cotton",
                    "Oversized graphic designer T-shirt intended as a visual focal point; best paired with simpler bottoms and footwear.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Saint Laurent",
                    "Silk Crepe de Chine Shirt",
                    "Top",
                    "39",
                    "Black",
                    "Black",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Silk",
                    "Lightweight luxury silk shirt with a refined drape; intended for evening wear, formal social settings, and tailored outfits.",
                    "2025-12-31",
                    4
            );

            addExisting(
                    repository,
                    "Bode",
                    "Embroidered Short-Sleeve Shirt",
                    "Top",
                    "M/L",
                    "Multi",
                    "Cream / Multicolor Embroidery",
                    "Spring/Summer",
                    "Special Occasion",
                    "Regular",
                    "Cotton",
                    "Decorative embroidered shirt with strong visual detail; suited to warm-weather statement outfits and special social occasions.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Brunello Cucinelli",
                    "Cashmere Crewneck Sweater",
                    "Top",
                    "48",
                    "Silver",
                    "Light Gray Silver",
                    "Fall/Winter",
                    "Special Occasion",
                    "Regular",
                    "Cashmere",
                    "Soft luxury cashmere knit providing lightweight warmth; suitable for refined cold-weather outfits and layering over collared shirts.",
                    "2026-01-09",
                    3
            );

            addExisting(
                    repository,
                    "Versace",
                    "Barocco Silk Shirt",
                    "Top",
                    "48",
                    "Gold",
                    "Black / Gold Barocco",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Silk",
                    "Bold printed silk shirt designed as a statement piece; best suited to nightlife, events, and other dressy occasions rather than everyday wear.",
                    "2025-11-21",
                    2
            );

            // Bottoms
            addExisting(
                    repository,
                    "Levi's",
                    "501 Original Fit Jeans",
                    "Bottom",
                    "30x30",
                    "Blue",
                    "Medium Stonewash",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton",
                    "Classic straight-leg denim suitable for everyday casual wear; durable and versatile enough to pair with T-shirts, sweaters, and jackets.",
                    "2026-08-27",
                    52
            );

            addExisting(
                    repository,
                    "Levi's",
                    "512 Slim Taper Fit Jeans",
                    "Bottom",
                    "30x30",
                    "Black",
                    "Black Leaf",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Cotton, Elastane",
                    "Slim tapered black jeans with slight stretch; useful for clean casual outfits and darker evening looks.",
                    "2026-08-21",
                    38
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "Wide-Fit Chino Pants",
                    "Bottom",
                    "M",
                    "Beige",
                    "Beige",
                    "All-Season",
                    "Everyday",
                    "Oversized",
                    "Cotton",
                    "Relaxed wide-leg chinos with a simple neutral appearance; suitable for everyday wear, minimalist outfits, and casual layering.",
                    "2026-08-25",
                    33
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "Smart Ankle Pants",
                    "Bottom",
                    "M",
                    "Gray",
                    "Dark Gray",
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Polyester, Rayon, Spandex",
                    "Clean tapered trousers that bridge casual and business-casual dressing; appropriate for work, dinners, and polished everyday outfits.",
                    "2026-08-16",
                    26
            );

            addExisting(
                    repository,
                    "Dickies",
                    "874 Original Work Pants",
                    "Bottom",
                    "30x30",
                    "Brown",
                    "Dark Brown",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Polyester, Cotton",
                    "Durable work pants with a structured straight fit; well suited to workwear-inspired outfits, skatewear, and frequent everyday use.",
                    "2026-08-24",
                    45
            );

            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Double Knee Pant",
                    "Bottom",
                    "30",
                    "Brown",
                    "Hamilton Brown",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton Canvas",
                    "Heavy-duty double-knee work pants with reinforced construction; useful for rugged casual outfits and colder-weather streetwear.",
                    "2026-08-13",
                    21
            );

            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Newel Pant",
                    "Bottom",
                    "30",
                    "Green",
                    "Dollar Green",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton Twill",
                    "Relaxed workwear-inspired pants with a durable twill fabric; versatile for everyday casual and utilitarian outfits.",
                    "2026-07-30",
                    18
            );

            addExisting(
                    repository,
                    "Nike",
                    "Sportswear Club Fleece Joggers",
                    "Bottom",
                    "M",
                    "Gray",
                    "Dark Grey Heather",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Cotton, Polyester",
                    "Soft fleece joggers intended for lounging, travel, errands, and casual cold-weather wear.",
                    "2026-08-28",
                    49
            );

            addExisting(
                    repository,
                    "Adidas",
                    "Adicolor Classics Firebird Track Pants",
                    "Bottom",
                    "M",
                    "Blue",
                    "Collegiate Royal",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Recycled Polyester",
                    "Sporty track pants with recognizable three-stripe styling; suitable for casual athletic and retro streetwear outfits.",
                    "2026-08-19",
                    29
            );

            addExisting(
                    repository,
                    "Lululemon",
                    "ABC Classic-Fit Trouser",
                    "Bottom",
                    "30",
                    "Black",
                    "Black",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Nylon, Elastane",
                    "Stretch technical trousers designed for mobility and comfort while maintaining a clean appearance; useful for travel, work, and everyday wear.",
                    "2026-08-26",
                    42
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Quandary Pants",
                    "Bottom",
                    "30",
                    "Green",
                    "Forge Grey Green",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled Nylon, Spandex",
                    "Lightweight stretch hiking pants built for movement and outdoor use; suitable for trails, travel, and changing warm-weather conditions.",
                    "2026-08-20",
                    17
            );

            addExisting(
                    repository,
                    "Arc'teryx",
                    "Gamma Pant",
                    "Bottom",
                    "30",
                    "Black",
                    "Black",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Nylon, Elastane",
                    "Durable stretch softshell pants designed for hiking, climbing, and active outdoor use; provides mobility and moderate weather resistance.",
                    "2026-08-12",
                    14
            );

            addExisting(
                    repository,
                    "The North Face",
                    "Freedom Insulated Pants",
                    "Bottom",
                    "M",
                    "Orange",
                    "Summit Gold",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Nylon, Polyester",
                    "Insulated snow pants designed for skiing and cold wet conditions; provides warmth and weather protection for winter outdoor activities.",
                    "2026-01-18",
                    6
            );

            addExisting(
                    repository,
                    "Columbia",
                    "Silver Ridge Utility Convertible Pants",
                    "Bottom",
                    "30x30",
                    "Beige",
                    "Tusk",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled Polyester",
                    "Lightweight hiking pants that convert into shorts; breathable and practical for warm-weather hiking, travel, and outdoor activities.",
                    "2026-07-26",
                    12
            );

            addExisting(
                    repository,
                    "Vuori",
                    "Kore Short",
                    "Bottom",
                    "M",
                    "Red",
                    "Brick",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Polyester, Elastane",
                    "Lightweight athletic shorts with built-in liner; suited to workouts, running, hiking, and warm-weather casual activity.",
                    "2026-08-23",
                    31
            );

            addExisting(
                    repository,
                    "Nike",
                    "Dri-FIT Challenger Running Shorts",
                    "Bottom",
                    "M",
                    "Yellow",
                    "University Gold",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Polyester",
                    "Breathable running shorts designed for high-output exercise and hot weather; lightweight construction helps manage sweat.",
                    "2026-08-22",
                    27
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Baggies Shorts",
                    "Bottom",
                    "M",
                    "Purple",
                    "Vessel Blue Purple",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled Nylon",
                    "Quick-drying casual outdoor shorts suited to hiking, swimming, travel, and warm-weather everyday wear.",
                    "2026-08-17",
                    24
            );

            addExisting(
                    repository,
                    "J.Crew",
                    "9-Inch Stretch Chino Short",
                    "Bottom",
                    "30",
                    "Pink",
                    "Faded Pink",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton, Elastane",
                    "Classic chino shorts with light stretch; suitable for summer outings, vacations, and clean smart-casual outfits.",
                    "2026-07-14",
                    11
            );

            addExisting(
                    repository,
                    "Polo Ralph Lauren",
                    "Stretch Classic Fit Chino Pants",
                    "Bottom",
                    "30x30",
                    "Beige",
                    "Classic Khaki",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton, Elastane",
                    "Traditional chinos with a polished but relaxed appearance; useful for business-casual settings, dinners, and everyday wear.",
                    "2026-08-04",
                    20
            );

            addExisting(
                    repository,
                    "Brooks Brothers",
                    "Regent Fit Stretch Advantage Chino Pants",
                    "Bottom",
                    "30x30",
                    "White",
                    "Stone White",
                    "Spring/Summer",
                    "Special Occasion",
                    "Slim",
                    "Cotton, Spandex",
                    "Clean tailored chinos suited to warm-weather smart-casual and semi-formal outfits; pairs well with polos and button-down shirts.",
                    "2026-06-28",
                    8
            );

            addExisting(
                    repository,
                    "Banana Republic",
                    "Signature Italian Hopsack Suit Pant",
                    "Bottom",
                    "30",
                    "Gray",
                    "Charcoal Gray",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Wool",
                    "Tailored wool trousers intended for suits, formal dinners, professional settings, and other dressier occasions.",
                    "2026-05-16",
                    10
            );

            addExisting(
                    repository,
                    "Theory",
                    "Zaine Pant in Precision Ponte",
                    "Bottom",
                    "30",
                    "Blue",
                    "Dark Navy",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Nylon, Rayon, Elastane",
                    "Minimal tailored trousers with stretch and a refined silhouette; suitable for work, travel, and elevated smart-casual outfits.",
                    "2026-07-09",
                    9
            );

            addExisting(
                    repository,
                    "A.P.C.",
                    "Petit Standard Jeans",
                    "Bottom",
                    "30",
                    "Blue",
                    "Raw Indigo",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Cotton",
                    "Raw denim jeans with a clean tapered silhouette that develop fading over time; suitable for minimalist everyday outfits.",
                    "2026-06-22",
                    13
            );

            addExisting(
                    repository,
                    "Nudie Jeans",
                    "Lean Dean Jeans",
                    "Bottom",
                    "30x30",
                    "Blue",
                    "Dry 16 Dips",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Organic Cotton",
                    "Slim tapered raw denim designed to develop a personalized fade through repeated wear; versatile for casual everyday outfits.",
                    "2026-05-29",
                    16
            );

            addExisting(
                    repository,
                    "Our Legacy",
                    "Third Cut Jeans",
                    "Bottom",
                    "30",
                    "Silver",
                    "Digital Denim Silver",
                    "All-Season",
                    "Special Occasion",
                    "Oversized",
                    "Cotton",
                    "Wide-leg designer denim with an unusual washed appearance; intended as a statement bottom for contemporary and fashion-forward outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Acne Studios",
                    "2021M Loose Fit Jeans",
                    "Bottom",
                    "30",
                    "Pink",
                    "Dusty Pink",
                    "All-Season",
                    "Casual",
                    "Oversized",
                    "Cotton",
                    "Loose designer denim with a wide silhouette and unconventional color; works well in relaxed contemporary and statement outfits.",
                    "2026-04-03",
                    5
            );

            addExisting(
                    repository,
                    "Stone Island",
                    "Garment-Dyed Cargo Trousers",
                    "Bottom",
                    "30",
                    "Green",
                    "Moss Green",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Utility cargo trousers with garment-dyed finish and multiple pockets; suited to technical streetwear and functional casual outfits.",
                    "2026-03-21",
                    7
            );

            addExisting(
                    repository,
                    "Fear of God Essentials",
                    "Fleece Sweatpants",
                    "Bottom",
                    "M",
                    "Brown",
                    "Light Oatmeal",
                    "Fall/Winter",
                    "Casual",
                    "Oversized",
                    "Cotton, Polyester",
                    "Heavy relaxed sweatpants with an oversized silhouette; intended for comfortable streetwear, lounging, and cold-weather casual outfits.",
                    "2026-02-27",
                    15
            );

            addExisting(
                    repository,
                    "Rick Owens",
                    "Bauhaus Cargo Trousers",
                    "Bottom",
                    "48",
                    "Black",
                    "Black",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Cotton, Elastane",
                    "Designer cargo trousers with distinctive pocket detailing and a dark avant-garde silhouette; suited to fashion-forward statement outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Issey Miyake Homme",
                    "Pleated Trousers",
                    "Bottom",
                    "2",
                    "Purple",
                    "Deep Purple",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Polyester",
                    "Lightweight permanently pleated trousers with exceptional movement and texture; appropriate for artistic, contemporary, and dressier outfits.",
                    "2026-03-02",
                    4
            );

            addExisting(
                    repository,
                    "Comme des Garçons Homme",
                    "Wide-Leg Wool Trousers",
                    "Bottom",
                    "M",
                    "Black",
                    "Black",
                    "Fall/Winter",
                    "Special Occasion",
                    "Oversized",
                    "Wool",
                    "Wide tailored wool trousers with an exaggerated silhouette; designed for formal yet unconventional fashion-forward outfits.",
                    "2025-12-20",
                    3
            );

            addExisting(
                    repository,
                    "Dries Van Noten",
                    "Printed Wide-Leg Trousers",
                    "Bottom",
                    "48",
                    "Multi",
                    "Multicolor Floral Print",
                    "Spring/Summer",
                    "Special Occasion",
                    "Oversized",
                    "Viscose",
                    "Flowing printed trousers with a bold pattern and relaxed shape; designed as a focal point for expressive warm-weather outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Gucci",
                    "GG Canvas Jogging Pants",
                    "Bottom",
                    "M",
                    "Gold",
                    "Beige / Ebony / Gold",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Cotton, Polyester",
                    "Luxury monogrammed casual trousers with prominent branding; intended for statement streetwear and elevated leisure outfits.",
                    "2025-11-15",
                    2
            );

            addExisting(
                    repository,
                    "Prada",
                    "Re-Nylon Bermudas",
                    "Bottom",
                    "48",
                    "Black",
                    "Black",
                    "Spring/Summer",
                    "Special Occasion",
                    "Regular",
                    "Recycled Nylon",
                    "Technical luxury shorts with a clean utilitarian appearance; suitable for warm-weather designer outfits and elevated streetwear.",
                    "2026-06-07",
                    6
            );

            // Outerwear
            addExisting(
                    repository,
                    "Patagonia",
                    "Nano Puff Jacket",
                    "Outerwear",
                    "M",
                    "Black",
                    "Black",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Recycled Polyester",
                    "Lightweight insulated jacket that provides warmth without much bulk; useful for cool-weather hiking, travel, and layering under a shell.",
                    "2026-08-20",
                    24
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Torrentshell 3L Rain Jacket",
                    "Outerwear",
                    "M",
                    "Blue",
                    "Smolder Blue",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Recycled Nylon",
                    "Waterproof rain shell designed for wet and windy conditions; useful for hiking, commuting, and layering over warmer clothing.",
                    "2026-08-16",
                    17
            );

            addExisting(
                    repository,
                    "Arc'teryx",
                    "Beta Jacket",
                    "Outerwear",
                    "M",
                    "Black",
                    "Black Sapphire",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Nylon, GORE-TEX",
                    "Waterproof technical shell built for hiking and changing mountain weather; designed to block rain and wind while allowing layering underneath.",
                    "2026-08-25",
                    19
            );

            addExisting(
                    repository,
                    "Arc'teryx",
                    "Atom Hoody",
                    "Outerwear",
                    "M",
                    "Orange",
                    "Solaris",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Nylon, Polyester Insulation",
                    "Lightweight synthetic insulated jacket for active cold-weather use; breathable enough for hiking while providing warmth during stops.",
                    "2026-07-29",
                    15
            );

            addExisting(
                    repository,
                    "The North Face",
                    "1996 Retro Nuptse Jacket",
                    "Outerwear",
                    "M",
                    "Red",
                    "TNF Red",
                    "Fall/Winter",
                    "Casual",
                    "Oversized",
                    "Nylon, Down",
                    "Warm high-loft down puffer designed for cold weather; boxy silhouette works especially well with casual and streetwear outfits.",
                    "2026-02-19",
                    28
            );

            addExisting(
                    repository,
                    "The North Face",
                    "Denali Jacket",
                    "Outerwear",
                    "M",
                    "Purple",
                    "Deep Mulberry",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Recycled Polyester Fleece",
                    "Heavy fleece jacket for cool and cold weather; useful as a casual outer layer or as insulation underneath a weatherproof shell.",
                    "2026-03-11",
                    22
            );

            addExisting(
                    repository,
                    "Columbia",
                    "Watertight II Rain Jacket",
                    "Outerwear",
                    "M",
                    "Yellow",
                    "Bright Gold",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Nylon, Polyester",
                    "Packable waterproof jacket intended for rain and mild outdoor conditions; practical for hiking, travel, and unpredictable spring weather.",
                    "2026-07-18",
                    12
            );

            addExisting(
                    repository,
                    "Outdoor Research",
                    "Helium Rain Jacket",
                    "Outerwear",
                    "M",
                    "Green",
                    "Loden",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Nylon",
                    "Ultralight waterproof shell designed for hiking and backpacking where low weight and packability matter more than heavy insulation.",
                    "2026-06-30",
                    8
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "Ultra Light Down Jacket",
                    "Outerwear",
                    "M",
                    "Gray",
                    "Dark Gray",
                    "Fall/Winter",
                    "Everyday",
                    "Slim",
                    "Nylon, Down, Feathers",
                    "Packable lightweight down jacket suitable for commuting, travel, and layering in cool weather without adding much bulk.",
                    "2026-08-22",
                    37
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "Blocktech Parka",
                    "Outerwear",
                    "M",
                    "Beige",
                    "Natural",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Polyester",
                    "Minimal weather-resistant parka designed for light rain and wind; versatile for commuting and understated everyday outfits.",
                    "2026-08-12",
                    26
            );

            addExisting(
                    repository,
                    "Carhartt",
                    "Detroit Jacket",
                    "Outerwear",
                    "M",
                    "Brown",
                    "Carhartt Brown",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Cotton Duck Canvas, Polyester",
                    "Rugged canvas work jacket with durable construction and a warm lining; well suited to workwear-inspired outfits and cool-weather everyday use.",
                    "2026-08-24",
                    34
            );

            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Michigan Coat",
                    "Outerwear",
                    "M",
                    "Green",
                    "Dollar Green",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Cotton Canvas",
                    "Workwear chore coat with multiple utility pockets and sturdy fabric; useful for layered casual and utilitarian outfits.",
                    "2026-07-12",
                    16
            );

            addExisting(
                    repository,
                    "Levi's",
                    "Trucker Jacket",
                    "Outerwear",
                    "M",
                    "Blue",
                    "Medium Wash Denim",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton Denim",
                    "Classic denim jacket suitable for mild weather and everyday layering; works easily with T-shirts, hoodies, and casual trousers.",
                    "2026-08-27",
                    43
            );

            addExisting(
                    repository,
                    "Wrangler",
                    "Unlined Denim Jacket",
                    "Outerwear",
                    "M",
                    "White",
                    "Ecru",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton Denim",
                    "Lightweight denim jacket in a bright neutral color; useful as a casual spring layer over simple warm-weather outfits.",
                    "2026-06-21",
                    9
            );

            addExisting(
                    repository,
                    "Alpha Industries",
                    "MA-1 Bomber Jacket",
                    "Outerwear",
                    "M",
                    "Green",
                    "Sage Green",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Nylon, Polyester",
                    "Military-inspired insulated bomber with wind-resistant nylon shell; suitable for cool weather, streetwear, and casual layered outfits.",
                    "2026-04-14",
                    20
            );

            addExisting(
                    repository,
                    "Schott NYC",
                    "Perfecto 618 Leather Motorcycle Jacket",
                    "Outerwear",
                    "38",
                    "Black",
                    "Black",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Leather",
                    "Heavy leather motorcycle jacket with iconic asymmetrical styling; works as a statement layer for evening and rock-inspired outfits.",
                    "2026-05-08",
                    10
            );

            addExisting(
                    repository,
                    "Barbour",
                    "Bedale Wax Jacket",
                    "Outerwear",
                    "38",
                    "Green",
                    "Sage",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Waxed Cotton",
                    "Traditional waxed jacket offering wind and light-rain protection; suited to cool-weather country, heritage, and smart-casual outfits.",
                    "2026-03-28",
                    13
            );

            addExisting(
                    repository,
                    "L.L.Bean",
                    "Mountain Classic Anorak",
                    "Outerwear",
                    "M",
                    "Multi",
                    "Navy / Teal / Purple",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Nylon",
                    "Lightweight wind-resistant anorak with retro outdoor styling; useful for hiking, camping, and breezy casual spring days.",
                    "2026-07-23",
                    14
            );

            addExisting(
                    repository,
                    "Marmot",
                    "PreCip Eco Jacket",
                    "Outerwear",
                    "M",
                    "Blue",
                    "Arctic Navy",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled Nylon",
                    "Lightweight waterproof shell made for rain, hiking, and travel; packs down easily and works best over separate insulation layers.",
                    "2026-05-27",
                    7
            );

            addExisting(
                    repository,
                    "Canada Goose",
                    "Langford Parka",
                    "Outerwear",
                    "M",
                    "Black",
                    "Black",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Polyester, Cotton, Down",
                    "Heavy insulated parka designed for very cold temperatures and prolonged winter exposure; better suited to severe cold than active high-output use.",
                    "2026-01-22",
                    11
            );

            addExisting(
                    repository,
                    "Moncler",
                    "Maya Short Down Jacket",
                    "Outerwear",
                    "2",
                    "Silver",
                    "Metallic Silver",
                    "Fall/Winter",
                    "Special Occasion",
                    "Regular",
                    "Nylon, Down, Feathers",
                    "Glossy luxury down jacket combining substantial winter insulation with statement styling; appropriate for cold-weather city and evening outfits.",
                    "2026-01-06",
                    5
            );

            addExisting(
                    repository,
                    "Stone Island",
                    "Garment-Dyed Crinkle Reps Jacket",
                    "Outerwear",
                    "M",
                    "Pink",
                    "Dusty Rose",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Nylon",
                    "Lightweight technical jacket with a garment-dyed finish and utility details; suited to transitional weather and technical streetwear outfits.",
                    "2026-06-09",
                    7
            );

            addExisting(
                    repository,
                    "Supreme",
                    "The North Face Mountain Jacket",
                    "Outerwear",
                    "M",
                    "Multi",
                    "Multicolor",
                    "Fall/Winter",
                    "Special Occasion",
                    "Oversized",
                    "Nylon",
                    "Bold collaborative shell with prominent graphics and streetwear styling; useful as a statement outer layer in wet or windy conditions.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Stussy",
                    "Wave Dye Beach Shell",
                    "Outerwear",
                    "M",
                    "Purple",
                    "Purple Dye",
                    "Spring/Summer",
                    "Casual",
                    "Oversized",
                    "Nylon",
                    "Relaxed lightweight shell with a colorful streetwear finish; useful for breezy weather, light layering, and casual transitional outfits.",
                    "2026-07-05",
                    6
            );

            addExisting(
                    repository,
                    "A.P.C.",
                    "Mac Ville",
                    "Outerwear",
                    "M",
                    "Beige",
                    "Camel",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Minimal lightweight mac coat with a clean silhouette; suitable for mild rain, commuting, and understated smart-casual outfits.",
                    "2026-04-26",
                    8
            );

            addExisting(
                    repository,
                    "Burberry",
                    "Kensington Heritage Trench Coat",
                    "Outerwear",
                    "48",
                    "Beige",
                    "Honey",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Cotton Gabardine",
                    "Classic tailored trench coat offering light weather protection; suitable for business wear, formal outfits, and polished rainy-day layering.",
                    "2026-04-02",
                    9
            );

            addExisting(
                    repository,
                    "Ralph Lauren",
                    "Polo Bear Varsity Jacket",
                    "Outerwear",
                    "M",
                    "Red",
                    "Red / Cream",
                    "Fall/Winter",
                    "Special Occasion",
                    "Regular",
                    "Wool, Leather",
                    "Collegiate varsity jacket with contrasting sleeves and statement detailing; suited to preppy casual and expressive cold-weather outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Acne Studios",
                    "Oversized Wool Blend Coat",
                    "Outerwear",
                    "48",
                    "Gray",
                    "Charcoal Gray",
                    "Fall/Winter",
                    "Special Occasion",
                    "Oversized",
                    "Wool, Polyester",
                    "Long oversized wool coat with a minimalist contemporary silhouette; provides warmth for dressier cold-weather and layered city outfits.",
                    "2026-02-04",
                    6
            );

            addExisting(
                    repository,
                    "Max Mara",
                    "101801 Icon Coat",
                    "Outerwear",
                    "M",
                    "Brown",
                    "Camel",
                    "Fall/Winter",
                    "Special Occasion",
                    "Oversized",
                    "Wool, Cashmere",
                    "Luxurious double-breasted camel coat with a relaxed silhouette; suited to polished winter outfits and formal or elevated daytime wear.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Saint Laurent",
                    "Teddy Jacket",
                    "Outerwear",
                    "48",
                    "Black",
                    "Black / White",
                    "Fall/Winter",
                    "Special Occasion",
                    "Slim",
                    "Wool, Leather",
                    "Slim luxury varsity jacket with contrasting leather details; designed for sharp evening outfits and elevated casual styling.",
                    "2026-03-17",
                    4
            );

            addExisting(
                    repository,
                    "Prada",
                    "Re-Nylon Blouson Jacket",
                    "Outerwear",
                    "48",
                    "Black",
                    "Black",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Recycled Nylon",
                    "Minimal luxury nylon jacket with technical utilitarian styling; lightweight enough for transitional weather and elevated streetwear.",
                    "2026-05-18",
                    5
            );

            addExisting(
                    repository,
                    "Gucci",
                    "GG Jacquard Cotton Jacket",
                    "Outerwear",
                    "48",
                    "Gold",
                    "Beige / Ebony GG",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Cotton",
                    "Monogrammed designer jacket with prominent branding; intended as a statement outer layer for luxury casual and social outfits.",
                    "2025-12-12",
                    2
            );

            addExisting(
                    repository,
                    "Bottega Veneta",
                    "Leather Blouson",
                    "Outerwear",
                    "48",
                    "Green",
                    "Parakeet Green",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Lambskin Leather",
                    "Premium leather blouson in a vivid green color; designed as a clean but striking statement layer for fashion-forward outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Maison Margiela",
                    "Collarless Wool Blazer",
                    "Outerwear",
                    "48",
                    "White",
                    "Off White",
                    "All-Season",
                    "Special Occasion",
                    "Oversized",
                    "Wool",
                    "Minimal collarless blazer with a relaxed designer silhouette; suitable for unconventional tailoring, events, and elevated layered outfits.",
                    "2026-02-25",
                    3
            );

            // Full-body
            addExisting(
                    repository,
                    "Uniqlo",
                    "Linen Blend Sleeveless Dress",
                    "Full-body",
                    "S",
                    "Beige",
                    "Natural Beige",
                    "Spring/Summer",
                    "Everyday",
                    "Regular",
                    "Linen, Rayon",
                    "Lightweight breathable sleeveless dress suited to hot weather, casual outings, and simple summer layering.",
                    "2026-08-20",
                    18
            );

            addExisting(
                    repository,
                    "COS",
                    "Voluminous Poplin Shirt Dress",
                    "Full-body",
                    "S",
                    "White",
                    "Optic White",
                    "Spring/Summer",
                    "Casual",
                    "Oversized",
                    "Cotton",
                    "Relaxed shirt dress with a clean minimalist silhouette; breathable enough for warm weather and polished enough for casual daytime events.",
                    "2026-08-10",
                    12
            );

            addExisting(
                    repository,
                    "Aritzia",
                    "Wilfred Market Slit Dress",
                    "Full-body",
                    "S",
                    "Black",
                    "Black",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Viscose, Elastane",
                    "Soft fitted midi dress with side slit; versatile for dinners, warm-weather outings, and elevated casual outfits.",
                    "2026-08-23",
                    16
            );

            addExisting(
                    repository,
                    "Everlane",
                    "The Japanese GoWeave Slip Dress",
                    "Full-body",
                    "S",
                    "Blue",
                    "Navy",
                    "Spring/Summer",
                    "Special Occasion",
                    "Slim",
                    "Triacetate, Polyester",
                    "Minimal slip dress with fluid drape and clean lines; suitable for dinners, events, and warm-weather formal occasions.",
                    "2026-07-26",
                    9
            );

            addExisting(
                    repository,
                    "Reformation",
                    "Juliette Dress",
                    "Full-body",
                    "S",
                    "Green",
                    "Sage Green",
                    "Spring/Summer",
                    "Special Occasion",
                    "Slim",
                    "Viscose",
                    "Fitted floral-style midi dress with a romantic silhouette; appropriate for weddings, dinners, and warm-weather special occasions.",
                    "2026-06-14",
                    7
            );

            addExisting(
                    repository,
                    "Free People",
                    "Hot Shot Onesie",
                    "Full-body",
                    "S",
                    "Gray",
                    "Heather Gray",
                    "All-Season",
                    "Everyday",
                    "Oversized",
                    "Cotton, Polyester",
                    "Relaxed casual one-piece designed for comfort, lounging, errands, and easy everyday layering.",
                    "2026-08-27",
                    29
            );

            addExisting(
                    repository,
                    "Dickies",
                    "Long Sleeve Coverall",
                    "Full-body",
                    "S",
                    "Brown",
                    "Dark Brown",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Polyester, Cotton",
                    "Durable utility coverall with workwear styling; suited to practical tasks, casual outfits, and layered streetwear looks.",
                    "2026-08-12",
                    14
            );

            addExisting(
                    repository,
                    "Carhartt",
                    "Loose Fit Denim Bib Overall",
                    "Full-body",
                    "S",
                    "Blue",
                    "Dark Stone Denim",
                    "All-Season",
                    "Casual",
                    "Oversized",
                    "Cotton Denim",
                    "Rugged denim overalls with a loose workwear fit; useful for casual layering, practical wear, and heritage-inspired outfits.",
                    "2026-07-30",
                    19
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Fleetwith Jumpsuit",
                    "Full-body",
                    "S",
                    "Black",
                    "Black",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled Polyester, Spandex",
                    "Lightweight stretch jumpsuit designed for travel and active warm-weather use; comfortable for walking, sightseeing, and casual outdoor activities.",
                    "2026-08-18",
                    11
            );

            addExisting(
                    repository,
                    "The North Face",
                    "Class V Jumpsuit",
                    "Full-body",
                    "S",
                    "Orange",
                    "Summit Gold",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Nylon, Elastane",
                    "Quick-drying technical jumpsuit suited to warm-weather travel, hiking, and casual outdoor use.",
                    "2026-07-19",
                    8
            );

            addExisting(
                    repository,
                    "Nike",
                    "Sportswear Essential Jumpsuit",
                    "Full-body",
                    "S",
                    "Black",
                    "Black / White",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton, Polyester",
                    "Sporty casual jumpsuit suited to errands, travel, and relaxed everyday wear.",
                    "2026-08-24",
                    21
            );

            addExisting(
                    repository,
                    "Adidas",
                    "Adicolor Classics Boiler Suit",
                    "Full-body",
                    "S",
                    "Red",
                    "Better Scarlet",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Cotton",
                    "Retro sportswear-inspired boiler suit with bold color and utility details; best for casual statement outfits.",
                    "2026-05-28",
                    6
            );

            addExisting(
                    repository,
                    "Levi's",
                    "Vintage Overall",
                    "Full-body",
                    "S",
                    "Blue",
                    "Medium Wash",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton Denim",
                    "Classic denim overall with vintage styling; easy to layer over T-shirts, sweaters, or lightweight tops.",
                    "2026-08-09",
                    17
            );

            addExisting(
                    repository,
                    "Madewell",
                    "Denim Oversized Jumpsuit",
                    "Full-body",
                    "S",
                    "Blue",
                    "Light Wash",
                    "All-Season",
                    "Casual",
                    "Oversized",
                    "Cotton Denim",
                    "Relaxed denim jumpsuit with an intentionally roomy silhouette; useful for casual layered outfits and transitional weather.",
                    "2026-07-06",
                    10
            );

            addExisting(
                    repository,
                    "Ganni",
                    "Printed Mesh Midi Dress",
                    "Full-body",
                    "S",
                    "Multi",
                    "Multicolor Floral",
                    "Spring/Summer",
                    "Special Occasion",
                    "Slim",
                    "Recycled Nylon, Elastane",
                    "Printed fitted midi dress with a playful contemporary look; suitable for parties, dinners, and warm-weather social occasions.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Staud",
                    "Wells Dress",
                    "Full-body",
                    "S",
                    "Yellow",
                    "Butter Yellow",
                    "Spring/Summer",
                    "Special Occasion",
                    "Regular",
                    "Cotton",
                    "Structured midi dress with a clean feminine silhouette; appropriate for daytime events, summer dinners, and special occasions.",
                    "2026-06-01",
                    5
            );

            addExisting(
                    repository,
                    "Jacquemus",
                    "La Robe Bahia",
                    "Full-body",
                    "36",
                    "Pink",
                    "Light Pink",
                    "Spring/Summer",
                    "Special Occasion",
                    "Slim",
                    "Viscose",
                    "Fitted designer dress with draped detailing and a warm-weather feel; intended for dinners, vacations, and statement occasions.",
                    "2026-05-10",
                    4
            );

            addExisting(
                    repository,
                    "Acne Studios",
                    "Denim Shirt Dress",
                    "Full-body",
                    "36",
                    "Blue",
                    "Vintage Blue",
                    "All-Season",
                    "Casual",
                    "Oversized",
                    "Cotton Denim",
                    "Oversized denim shirt dress with a contemporary silhouette; suitable for casual layering and transitional weather.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Issey Miyake",
                    "Pleats Please Jumpsuit",
                    "Full-body",
                    "2",
                    "Purple",
                    "Deep Purple",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Polyester",
                    "Lightweight permanently pleated jumpsuit with fluid movement; suited to artistic, contemporary, and dressier occasions.",
                    "2026-04-21",
                    3
            );

            addExisting(
                    repository,
                    "Comme des Garçons",
                    "Asymmetric Wool Dress",
                    "Full-body",
                    "S",
                    "Black",
                    "Black",
                    "Fall/Winter",
                    "Special Occasion",
                    "Oversized",
                    "Wool",
                    "Avant-garde asymmetric wool dress with a sculptural silhouette; designed for fashion-forward events and colder-weather special occasions.",
                    "2026-02-14",
                    2
            );

            addExisting(
                    repository,
                    "Rick Owens",
                    "Kite Jumpsuit",
                    "Full-body",
                    "40",
                    "Gray",
                    "Dust Gray",
                    "All-Season",
                    "Special Occasion",
                    "Oversized",
                    "Viscose, Silk",
                    "Draped avant-garde jumpsuit with elongated proportions; intended as a statement piece for fashion-focused events.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Prada",
                    "Re-Nylon Jumpsuit",
                    "Full-body",
                    "40",
                    "Black",
                    "Black",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Recycled Nylon",
                    "Technical luxury jumpsuit with utilitarian styling; suitable for elevated streetwear and contemporary statement outfits.",
                    "2026-03-02",
                    3
            );

            addExisting(
                    repository,
                    "Bottega Veneta",
                    "Fluid Satin Jumpsuit",
                    "Full-body",
                    "40",
                    "Green",
                    "Parakeet Green",
                    "Spring/Summer",
                    "Special Occasion",
                    "Regular",
                    "Viscose",
                    "Fluid luxury jumpsuit in a vivid green tone; intended for formal dinners, events, and high-impact evening outfits.",
                    "2026-05-22",
                    2
            );

            addExisting(
                    repository,
                    "Saint Laurent",
                    "Tuxedo Jumpsuit",
                    "Full-body",
                    "38",
                    "Black",
                    "Black",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Wool, Silk",
                    "Sharp tailored jumpsuit inspired by tuxedo dressing; suited to formal evening events and polished special occasions.",
                    "2025-12-28",
                    3
            );

            addExisting(
                    repository,
                    "Zimmermann",
                    "Silk Wrap Midi Dress",
                    "Full-body",
                    "1",
                    "Orange",
                    "Burnt Orange",
                    "Spring/Summer",
                    "Special Occasion",
                    "Regular",
                    "Silk",
                    "Flowing silk wrap dress designed for warm-weather events, vacations, and elegant daytime occasions.",
                    "2026-04-30",
                    4
            );

            addExisting(
                    repository,
                    "Max Mara",
                    "Wool Jersey Midi Dress",
                    "Full-body",
                    "S",
                    "Brown",
                    "Camel",
                    "Fall/Winter",
                    "Special Occasion",
                    "Regular",
                    "Virgin Wool",
                    "Warm refined wool dress with a minimal silhouette; suitable for cold-weather professional settings and polished special occasions.",
                    "2026-01-25",
                    6
            );

            addExisting(
                    repository,
                    "Versace",
                    "Barocco Print Silk Dress",
                    "Full-body",
                    "40",
                    "Gold",
                    "Black / Gold Barocco",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Silk",
                    "Bold silk dress with prominent Barocco print; intended for nightlife, parties, and formal statement outfits.",
                    "2025-11-17",
                    2
            );

            addExisting(
                    repository,
                    "Paco Rabanne",
                    "Metallic Disc Mini Dress",
                    "Full-body",
                    "S",
                    "Silver",
                    "Silver Metallic",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Metal, Polyester",
                    "Highly reflective metallic mini dress designed for parties, nightlife, and dramatic statement occasions rather than everyday use.",
                    null,
                    0
            );

            // Footwear

            addExisting(
                    repository,
                    "Nike",
                    "Air Force 1 '07",
                    "Footwear",
                    "9",
                    "White",
                    "Triple White",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Leather, Rubber",
                    "Classic white leather sneaker suited to everyday casual wear; versatile with denim, chinos, shorts, and relaxed streetwear.",
                    "2026-08-28",
                    61
            );

            addExisting(
                    repository,
                    "Nike",
                    "Air Max 90",
                    "Footwear",
                    "9",
                    "Gray",
                    "Cool Grey / White",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Mesh, Leather, Synthetic, Rubber",
                    "Cushioned lifestyle sneaker with retro running styling; comfortable for walking, errands, and casual everyday outfits.",
                    "2026-08-22",
                    37
            );

            addExisting(
                    repository,
                    "Adidas",
                    "Samba OG",
                    "Footwear",
                    "9",
                    "Black",
                    "Core Black / Cloud White",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Leather, Suede, Rubber",
                    "Low-profile leather sneaker with a narrow silhouette; works well with casual, minimalist, and retro-inspired outfits.",
                    "2026-08-25",
                    42
            );

            addExisting(
                    repository,
                    "New Balance",
                    "990v6",
                    "Footwear",
                    "9",
                    "Gray",
                    "Grey / Silver",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Mesh, Suede, Synthetic, Rubber",
                    "Highly cushioned everyday sneaker designed for walking and prolonged wear; pairs easily with casual and relaxed outfits.",
                    "2026-08-27",
                    48
            );

            addExisting(
                    repository,
                    "ASICS",
                    "GEL-Kayano 14",
                    "Footwear",
                    "9",
                    "Silver",
                    "White / Pure Silver",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Mesh, Synthetic, Rubber",
                    "Technical retro runner with breathable mesh and visible cushioning; suited to walking, casual wear, and sporty fashion-focused outfits.",
                    "2026-08-19",
                    31
            );

            addExisting(
                    repository,
                    "Salomon",
                    "XT-6",
                    "Footwear",
                    "9",
                    "Beige",
                    "Vanilla Ice / Almond Milk",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Mesh, TPU, Rubber",
                    "Technical trail-inspired sneaker with strong grip and supportive construction; useful for walking, light trails, travel, and technical streetwear.",
                    "2026-08-18",
                    23
            );

            addExisting(
                    repository,
                    "Hoka",
                    "Clifton 9",
                    "Footwear",
                    "9",
                    "Blue",
                    "Skyward Blue",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Engineered Mesh, EVA Foam, Rubber",
                    "Lightweight highly cushioned running shoe designed for road running, long walks, and high-mileage comfort.",
                    "2026-08-24",
                    28
            );

            addExisting(
                    repository,
                    "Brooks",
                    "Ghost 16",
                    "Footwear",
                    "9",
                    "Orange",
                    "Orange / Black",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Mesh, Foam, Rubber",
                    "Neutral running shoe with soft cushioning and breathable upper; suitable for road running, gym sessions, and long walks.",
                    "2026-08-20",
                    21
            );

            addExisting(
                    repository,
                    "Saucony",
                    "Endorphin Speed 4",
                    "Footwear",
                    "9",
                    "Yellow",
                    "Citron / Black",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Mesh, Nylon Plate, Foam, Rubber",
                    "Lightweight performance running shoe intended for faster training and road runs; responsive construction favors athletic use over casual wear.",
                    "2026-08-16",
                    17
            );

            addExisting(
                    repository,
                    "On",
                    "Cloudmonster",
                    "Footwear",
                    "9",
                    "White",
                    "Undyed White",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Mesh, Foam, Rubber",
                    "Maximum-cushion running shoe with a lightweight breathable upper; useful for running, travel, and extended walking.",
                    "2026-08-10",
                    14
            );

            addExisting(
                    repository,
                    "Merrell",
                    "Moab 3",
                    "Footwear",
                    "9",
                    "Brown",
                    "Walnut",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Suede, Mesh, Rubber",
                    "Durable hiking shoe with strong traction and supportive construction; intended for trails, hiking, and uneven outdoor terrain.",
                    "2026-08-21",
                    19
            );

            addExisting(
                    repository,
                    "Salomon",
                    "X Ultra 4 Mid GORE-TEX",
                    "Footwear",
                    "9",
                    "Green",
                    "Olive Night",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Synthetic, Textile, GORE-TEX, Rubber",
                    "Waterproof mid-height hiking boot with trail traction and ankle support; suited to wet, cold, and uneven hiking conditions.",
                    "2026-03-29",
                    12
            );

            addExisting(
                    repository,
                    "Danner",
                    "Mountain Light",
                    "Footwear",
                    "9",
                    "Brown",
                    "Cascade Clovis",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Leather, GORE-TEX, Vibram Rubber",
                    "Heavy-duty leather hiking boot with waterproof lining and rugged traction; appropriate for cold-weather hikes and heritage outdoor outfits.",
                    "2026-02-14",
                    9
            );

            addExisting(
                    repository,
                    "Timberland",
                    "6-Inch Premium Waterproof Boot",
                    "Footwear",
                    "9",
                    "Yellow",
                    "Wheat Nubuck",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Nubuck Leather, Rubber",
                    "Waterproof insulated work-inspired boot suited to rain, cold weather, and casual streetwear; durable enough for rough everyday conditions.",
                    "2026-01-30",
                    16
            );

            addExisting(
                    repository,
                    "Blundstone",
                    "Classic 550 Chelsea Boot",
                    "Footwear",
                    "9",
                    "Brown",
                    "Walnut",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Leather, TPU",
                    "Slip-on leather Chelsea boot with weather-resistant construction; versatile for commuting, travel, casual wear, and light outdoor use.",
                    "2026-08-06",
                    26
            );

            addExisting(
                    repository,
                    "Dr. Martens",
                    "1460 Smooth Leather Lace Up Boots",
                    "Footwear",
                    "9",
                    "Black",
                    "Black Smooth",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Leather, PVC",
                    "Structured leather combat-style boot with a durable sole; works well in punk, workwear, and darker casual outfits.",
                    "2026-04-18",
                    18
            );

            addExisting(
                    repository,
                    "Red Wing",
                    "Iron Ranger",
                    "Footwear",
                    "9D",
                    "Brown",
                    "Amber Harness",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Full-Grain Leather, Cork, Rubber",
                    "Heavy leather heritage boot that develops patina over time; suitable for rugged workwear and long-term everyday wear.",
                    "2026-03-10",
                    13
            );

            addExisting(
                    repository,
                    "Birkenstock",
                    "Arizona",
                    "Footwear",
                    "42",
                    "Beige",
                    "Taupe Suede",
                    "Spring/Summer",
                    "Everyday",
                    "Regular",
                    "Suede, Cork, EVA",
                    "Open two-strap sandal with supportive cork footbed; suited to warm weather, travel, errands, and relaxed casual outfits.",
                    "2026-08-26",
                    34
            );

            addExisting(
                    repository,
                    "Teva",
                    "Original Universal",
                    "Footwear",
                    "9",
                    "Green",
                    "Archive Green",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Polyester Webbing, EVA, Rubber",
                    "Quick-drying outdoor sandal suitable for hiking, water activities, camping, and hot-weather travel.",
                    "2026-07-31",
                    15
            );

            addExisting(
                    repository,
                    "Crocs",
                    "Classic Clog",
                    "Footwear",
                    "M9",
                    "Pink",
                    "Quartz Pink",
                    "Spring/Summer",
                    "Everyday",
                    "Oversized",
                    "EVA",
                    "Lightweight slip-on clog designed for comfort, casual errands, recovery, and wet or warm conditions.",
                    "2026-08-23",
                    40
            );

            addExisting(
                    repository,
                    "Vans",
                    "Authentic",
                    "Footwear",
                    "9",
                    "Red",
                    "Racing Red",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Canvas, Rubber",
                    "Low-profile canvas sneaker with skate-inspired styling; suited to warm-weather casual wear and simple streetwear outfits.",
                    "2026-07-22",
                    24
            );

            addExisting(
                    repository,
                    "Converse",
                    "Chuck 70 High Top",
                    "Footwear",
                    "9",
                    "Purple",
                    "Deep Purple",
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Canvas, Rubber",
                    "Classic high-top canvas sneaker with a vintage silhouette; works with casual, punk-inspired, and streetwear outfits.",
                    "2026-06-28",
                    20
            );

            addExisting(
                    repository,
                    "Puma",
                    "Suede Classic XXI",
                    "Footwear",
                    "9",
                    "Orange",
                    "Burnt Orange",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Suede, Rubber",
                    "Low-profile suede sneaker with retro styling; best suited to casual outfits and warm-weather everyday wear.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Clarks",
                    "Wallabee",
                    "Footwear",
                    "9",
                    "Beige",
                    "Maple Suede",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Suede, Crepe Rubber",
                    "Soft suede moccasin-style shoe with a distinctive crepe sole; useful for relaxed smart-casual, heritage, and streetwear outfits.",
                    "2026-05-17",
                    11
            );

            addExisting(
                    repository,
                    "G.H. Bass",
                    "Larson Weejuns Loafer",
                    "Footwear",
                    "9",
                    "Brown",
                    "Wine Leather",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Leather, Rubber",
                    "Classic penny loafer appropriate for smart-casual outfits, dinners, business casual, and traditional preppy styling.",
                    "2026-05-04",
                    10
            );

            addExisting(
                    repository,
                    "Allen Edmonds",
                    "Park Avenue Oxford",
                    "Footwear",
                    "9D",
                    "Black",
                    "Black Calfskin",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Calfskin Leather, Leather Sole",
                    "Formal cap-toe Oxford designed for suits, weddings, interviews, and other professional or formal occasions.",
                    "2026-04-11",
                    8
            );

            addExisting(
                    repository,
                    "Johnston & Murphy",
                    "Melton Cap Toe",
                    "Footwear",
                    "9",
                    "Brown",
                    "Mahogany",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Leather, Rubber",
                    "Polished cap-toe dress shoe suited to business attire, formal events, and dressier smart-casual outfits.",
                    "2026-03-19",
                    6
            );

            addExisting(
                    repository,
                    "Common Projects",
                    "Original Achilles Low",
                    "Footwear",
                    "42",
                    "White",
                    "White",
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Leather, Rubber",
                    "Minimal luxury leather sneaker with nearly no visible branding; suited to clean casual, minimalist, and elevated everyday outfits.",
                    "2026-06-11",
                    9
            );

            addExisting(
                    repository,
                    "Maison Margiela",
                    "Replica Sneakers",
                    "Footwear",
                    "42",
                    "Gray",
                    "Gray / Gum",
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Leather, Suede, Rubber",
                    "Luxury reinterpretation of a vintage German trainer; works well in understated designer and minimalist casual outfits.",
                    "2026-05-26",
                    7
            );

            addExisting(
                    repository,
                    "Balenciaga",
                    "Triple S Sneaker",
                    "Footwear",
                    "42",
                    "Multi",
                    "White / Red / Blue",
                    "All-Season",
                    "Special Occasion",
                    "Oversized",
                    "Mesh, Leather, Rubber",
                    "Chunky oversized designer sneaker with a highly distinctive silhouette; intended as a statement piece for fashion-forward streetwear.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Rick Owens",
                    "Geobasket",
                    "Footwear",
                    "42",
                    "Black",
                    "Black / Milk",
                    "All-Season",
                    "Special Occasion",
                    "Oversized",
                    "Leather, Rubber",
                    "High-top designer sneaker with exaggerated proportions and an avant-garde silhouette; suited to dark, fashion-focused statement outfits.",
                    "2026-02-25",
                    4
            );

            addExisting(
                    repository,
                    "Prada",
                    "Monolith Leather Loafers",
                    "Footwear",
                    "8",
                    "Black",
                    "Black",
                    "All-Season",
                    "Special Occasion",
                    "Oversized",
                    "Leather, Rubber",
                    "Heavy platform loafer that combines formal styling with an exaggerated sole; suited to contemporary designer and statement outfits.",
                    "2026-03-07",
                    5
            );

            addExisting(
                    repository,
                    "Bottega Veneta",
                    "Puddle Bomber Boots",
                    "Footwear",
                    "42",
                    "Green",
                    "Parakeet",
                    "Fall/Winter",
                    "Special Occasion",
                    "Oversized",
                    "Leather, Rubber",
                    "Chunky designer boot with a bold rounded silhouette and vivid color; intended for fashion-forward wet-weather and statement outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Gucci",
                    "Horsebit 1953 Loafer",
                    "Footwear",
                    "8",
                    "Gold",
                    "Black Leather / Gold Horsebit",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Leather, Metal",
                    "Classic luxury loafer with gold horsebit hardware; appropriate for formal events, dinners, tailoring, and polished smart-casual outfits.",
                    "2026-01-16",
                    3
            );

            addExisting(
                    repository,
                    "Christian Louboutin",
                    "Greggo Oxford",
                    "Footwear",
                    "42",
                    "Black",
                    "Black / Red Sole",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Leather",
                    "Sleek formal Oxford with signature red sole; intended for suits, formal evenings, weddings, and luxury dress occasions.",
                    "2025-12-20",
                    2
            );

            addExisting(
                    repository,
                    "Versace",
                    "Odissea Sneaker",
                    "Footwear",
                    "42",
                    "Gold",
                    "White / Gold",
                    "All-Season",
                    "Special Occasion",
                    "Oversized",
                    "Leather, Synthetic, Rubber",
                    "Bold luxury sneaker with sculpted sole and metallic detailing; designed for statement streetwear and fashion-focused casual outfits.",
                    "2026-02-02",
                    3
            );  
            
            // Undergarments
            addExisting(
                    repository,
                    "Uniqlo",
                    "AIRism Boxer Briefs",
                    "Undergarment",
                    "M",
                    "Black",
                    "Black",
                    "Spring/Summer",
                    "Everyday",
                    "Slim",
                    "Nylon, Spandex",
                    "Lightweight moisture-wicking boxer briefs designed for hot weather and everyday use; smooth fabric works well under slim clothing.",
                    "2026-08-28",
                    57
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "HEATTECH Tights",
                    "Undergarment",
                    "M",
                    "Gray",
                    "Dark Gray",
                    "Fall/Winter",
                    "Everyday",
                    "Slim",
                    "Polyester, Acrylic, Rayon, Spandex",
                    "Thermal base-layer tights intended to retain warmth underneath pants during cold weather, commuting, and winter outdoor activities.",
                    "2026-02-18",
                    24
            );

            addExisting(
                    repository,
                    "Hanes",
                    "ComfortSoft Boxer Briefs",
                    "Undergarment",
                    "M",
                    "White",
                    "White",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton, Spandex",
                    "Simple soft cotton boxer briefs intended for frequent everyday use and general comfort.",
                    "2026-08-27",
                    63
            );

            addExisting(
                    repository,
                    "Fruit of the Loom",
                    "CoolZone Boxer Briefs",
                    "Undergarment",
                    "M",
                    "Blue",
                    "Navy",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton, Polyester",
                    "Breathable everyday boxer briefs with ventilation intended to improve comfort during warm conditions and regular daily wear.",
                    "2026-08-25",
                    46
            );

            addExisting(
                    repository,
                    "Calvin Klein",
                    "Cotton Stretch Boxer Brief",
                    "Undergarment",
                    "M",
                    "Black",
                    "Black",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Cotton, Elastane",
                    "Close-fitting stretch cotton boxer briefs with a smooth silhouette; versatile for everyday wear beneath fitted trousers.",
                    "2026-08-26",
                    51
            );

            addExisting(
                    repository,
                    "Calvin Klein",
                    "Modern Cotton Trunk",
                    "Undergarment",
                    "M",
                    "Gray",
                    "Heather Gray",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Cotton, Elastane",
                    "Short-cut stretch trunks designed for everyday comfort and minimal bulk beneath clothing.",
                    "2026-08-22",
                    39
            );

            addExisting(
                    repository,
                    "Tommy Hilfiger",
                    "Cotton Classics Boxer Brief",
                    "Undergarment",
                    "M",
                    "Red",
                    "Primary Red",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton, Elastane",
                    "Classic cotton boxer briefs with light stretch; intended for comfortable everyday use.",
                    "2026-08-17",
                    31
            );

            addExisting(
                    repository,
                    "Polo Ralph Lauren",
                    "Classic Fit Woven Boxer",
                    "Undergarment",
                    "M",
                    "Blue",
                    "Blue Stripe",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton",
                    "Loose woven cotton boxers with a breathable relaxed fit; comfortable for lounging, sleeping, and everyday wear.",
                    "2026-08-15",
                    26
            );

            addExisting(
                    repository,
                    "Jockey",
                    "Classic Full Rise Brief",
                    "Undergarment",
                    "M",
                    "White",
                    "White",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton",
                    "Traditional full-rise cotton briefs designed for simple everyday comfort and support.",
                    "2026-07-29",
                    22
            );

            addExisting(
                    repository,
                    "SAXX",
                    "DropTemp Cooling Cotton Boxer Brief",
                    "Undergarment",
                    "M",
                    "Green",
                    "Dark Forest",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Cotton, Modal, Elastane",
                    "Cooling boxer briefs designed to improve airflow and moisture management; useful for hot weather, travel, and active days.",
                    "2026-08-21",
                    19
            );

            addExisting(
                    repository,
                    "ExOfficio",
                    "Give-N-Go 2.0 Boxer Brief",
                    "Undergarment",
                    "M",
                    "Beige",
                    "Buff",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Nylon, Elastane",
                    "Quick-drying travel underwear designed for hiking, backpacking, and trips where lightweight wash-and-wear performance is useful.",
                    "2026-07-24",
                    18
            );

            addExisting(
                    repository,
                    "Smartwool",
                    "Merino Boxer Brief",
                    "Undergarment",
                    "M",
                    "Purple",
                    "Deep Navy Purple",
                    "Fall/Winter",
                    "Casual",
                    "Slim",
                    "Merino Wool, Nylon, Elastane",
                    "Temperature-regulating merino boxer briefs that manage odor and moisture; useful for hiking, travel, and cool-weather outdoor activity.",
                    "2026-06-20",
                    13
            );

            addExisting(
                    repository,
                    "Icebreaker",
                    "Anatomica Boxers",
                    "Undergarment",
                    "M",
                    "Green",
                    "Loden",
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Merino Wool, Nylon, Elastane",
                    "Lightweight merino underwear designed for temperature regulation and odor resistance during hiking, travel, and extended wear.",
                    "2026-05-30",
                    11
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Essential Boxer Briefs",
                    "Undergarment",
                    "M",
                    "Orange",
                    "Burnished Red Orange",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Tencel Lyocell, Spandex",
                    "Soft breathable boxer briefs with stretch and moisture management; useful for everyday wear and light outdoor activity.",
                    "2026-08-12",
                    17
            );

            addExisting(
                    repository,
                    "Nike",
                    "Dri-FIT Essential Micro Boxer Briefs",
                    "Undergarment",
                    "M",
                    "Black",
                    "Black / White",
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Polyester, Spandex",
                    "Stretch moisture-wicking performance underwear intended for workouts, running, and active everyday use.",
                    "2026-08-24",
                    34
            );

            addExisting(
                    repository,
                    "Under Armour",
                    "Tech Boxerjock",
                    "Undergarment",
                    "M",
                    "Blue",
                    "Royal Blue",
                    "All-Season",
                    "Casual",
                    "Slim",
                    "Polyester, Elastane",
                    "Performance boxer briefs with quick-drying stretch fabric; designed for workouts, sports, and high-output activity.",
                    "2026-08-19",
                    28
            );

            addExisting(
                    repository,
                    "Lululemon",
                    "Always In Motion Boxer",
                    "Undergarment",
                    "M",
                    "Brown",
                    "Espresso",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Modal, Elastane",
                    "Soft stretch boxer briefs designed for unrestricted movement and all-day comfort during work, travel, and daily activity.",
                    "2026-08-23",
                    25
            );

            addExisting(
                    repository,
                    "Mack Weldon",
                    "AIRKNITx Boxer Brief",
                    "Undergarment",
                    "M",
                    "Silver",
                    "Silver Birch",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "Nylon, Polyester, Spandex",
                    "Highly breathable technical boxer briefs designed to reduce heat and moisture during exercise and hot-weather wear.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "CDLP",
                    "Lyocell Boxer Brief",
                    "Undergarment",
                    "M",
                    "Yellow",
                    "Mustard Yellow",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Lyocell, Elastane",
                    "Premium soft lyocell boxer briefs with a smooth fitted construction; intended for comfortable everyday use.",
                    "2026-06-11",
                    9
            );

            addExisting(
                    repository,
                    "Sunspel",
                    "Superfine Cotton Boxer Shorts",
                    "Undergarment",
                    "M",
                    "Pink",
                    "Pale Pink",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Cotton",
                    "Lightweight premium woven boxers made from fine cotton; breathable and suited to relaxed everyday wear and sleeping.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Zimmerli",
                    "Royal Classic Boxer Brief",
                    "Undergarment",
                    "M",
                    "Beige",
                    "Ivory Beige",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Cotton, Elastane",
                    "Luxury fine-cotton boxer briefs with a smooth close fit; intended for comfort beneath tailored and formal clothing.",
                    "2026-04-17",
                    5
            );

            addExisting(
                    repository,
                    "Hanro",
                    "Cotton Superior Boxer Brief",
                    "Undergarment",
                    "M",
                    "Gray",
                    "Graphite",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Cotton, Elastane",
                    "Premium long-staple cotton underwear with a refined smooth finish; suitable beneath dress trousers and fitted clothing.",
                    "2026-03-25",
                    4
            );

            addExisting(
                    repository,
                    "Uniqlo",
                    "AIRism Cotton Crew Neck T-Shirt",
                    "Undergarment",
                    "M",
                    "White",
                    "White",
                    "Spring/Summer",
                    "Everyday",
                    "Slim",
                    "Cotton, Polyester",
                    "Lightweight undershirt designed to manage heat and moisture beneath shirts; particularly useful during warm weather.",
                    "2026-08-20",
                    33
            );

            addExisting(
                    repository,
                    "Hanes",
                    "ComfortSoft Crewneck Undershirt",
                    "Undergarment",
                    "M",
                    "White",
                    "White",
                    "All-Season",
                    "Everyday",
                    "Slim",
                    "Cotton",
                    "Basic cotton undershirt for absorbing moisture and providing a comfortable layer beneath button-down shirts and sweaters.",
                    "2026-08-14",
                    36
            );

            addExisting(
                    repository,
                    "Smartwool",
                    "Classic Thermal Merino Base Layer Crew",
                    "Undergarment",
                    "M",
                    "Red",
                    "Burgundy Red",
                    "Fall/Winter",
                    "Casual",
                    "Slim",
                    "Merino Wool",
                    "Warm merino base-layer top designed for skiing, hiking, and prolonged cold-weather activity while managing moisture and odor.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Icebreaker",
                    "200 Oasis Long Sleeve Crewe",
                    "Undergarment",
                    "M",
                    "Black",
                    "Black",
                    "Fall/Winter",
                    "Casual",
                    "Slim",
                    "Merino Wool",
                    "Midweight merino thermal base layer suited to hiking, skiing, travel, and cold-weather layering beneath outerwear.",
                    "2026-01-21",
                    8
            );

            addExisting(
                    repository,
                    "Dolce & Gabbana",
                    "Stretch Cotton Logo Briefs",
                    "Undergarment",
                    "M",
                    "Gold",
                    "Black / Gold Logo",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Cotton, Elastane",
                    "Designer stretch briefs with prominent branded waistband; fitted construction minimizes bulk beneath tailored clothing.",
                    null,
                    0
            );

            // Accessories
            addExisting(
                    repository,
                    "Uniqlo",
                    "Round Mini Shoulder Bag",
                    "Accessory",
                    "One Size",
                    "Black",
                    "Black",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Nylon, Polyester",
                    "Compact crossbody bag for everyday essentials; lightweight and practical for errands, travel, and casual outfits.",
                    "2026-08-27",
                    44
            );

            addExisting(
                    repository,
                    "Baggu",
                    "Medium Nylon Crescent Bag",
                    "Accessory",
                    "One Size",
                    "Blue",
                    "Navy",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Recycled Nylon",
                    "Soft lightweight shoulder bag with enough room for daily essentials; useful for commuting, casual outings, and travel.",
                    "2026-08-24",
                    31
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Black Hole Mini MLC",
                    "Accessory",
                    "30L",
                    "Green",
                    "Smolder Blue Green",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Recycled Polyester",
                    "Durable travel bag that can be carried as a backpack or briefcase; designed for flights, weekend trips, and organized travel.",
                    "2026-08-15",
                    14
            );

            addExisting(
                    repository,
                    "The North Face",
                    "Borealis Backpack",
                    "Accessory",
                    "28L",
                    "Gray",
                    "TNF Dark Grey Heather",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Recycled Polyester, Nylon",
                    "Structured backpack with laptop storage and external organization; suited to school, commuting, travel, and light outdoor use.",
                    "2026-08-26",
                    39
            );

            addExisting(
                    repository,
                    "Arc'teryx",
                    "Mantis 2 Waist Pack",
                    "Accessory",
                    "2.5L",
                    "Orange",
                    "Solaris",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Recycled Polyester",
                    "Small technical waist or crossbody pack for carrying essentials during hiking, travel, and active casual use.",
                    "2026-08-20",
                    18
            );

            addExisting(
                    repository,
                    "Fjallraven",
                    "Kanken Backpack",
                    "Accessory",
                    "16L",
                    "Red",
                    "Ox Red",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Vinylon F",
                    "Simple rectangular backpack with lightweight durable construction; practical for school, commuting, and casual daily use.",
                    "2026-08-22",
                    28
            );

            addExisting(
                    repository,
                    "Carhartt WIP",
                    "Essentials Bag",
                    "Accessory",
                    "One Size",
                    "Brown",
                    "Hamilton Brown",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Polyester Canvas",
                    "Compact utility shoulder bag with multiple pockets; useful for streetwear outfits, errands, and carrying small daily items.",
                    "2026-07-30",
                    20
            );

            addExisting(
                    repository,
                    "Porter-Yoshida & Co.",
                    "Tanker Shoulder Bag",
                    "Accessory",
                    "One Size",
                    "Green",
                    "Sage Green",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Nylon",
                    "Japanese utility shoulder bag with padded construction and multiple compartments; suited to travel and functional everyday outfits.",
                    "2026-07-14",
                    11
            );

            addExisting(
                    repository,
                    "Telfar",
                    "Medium Shopping Bag",
                    "Accessory",
                    "Medium",
                    "Purple",
                    "Lavender",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Vegan Leather",
                    "Structured tote with shoulder and crossbody straps; works as a practical everyday bag and recognizable fashion accessory.",
                    "2026-06-28",
                    9
            );

            addExisting(
                    repository,
                    "Longchamp",
                    "Le Pliage Original Large",
                    "Accessory",
                    "Large",
                    "Beige",
                    "Paper Beige",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Recycled Polyamide, Leather",
                    "Lightweight foldable tote with substantial capacity; useful for commuting, travel, shopping, and everyday carrying.",
                    "2026-08-18",
                    26
            );

            addExisting(
                    repository,
                    "Coach",
                    "Tabby Shoulder Bag 26",
                    "Accessory",
                    "One Size",
                    "Pink",
                    "Chalk Pink",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Leather",
                    "Structured leather shoulder bag with polished hardware; appropriate for dinners, events, and elevated casual outfits.",
                    "2026-05-29",
                    7
            );

            addExisting(
                    repository,
                    "Bottega Veneta",
                    "Cassette Crossbody Bag",
                    "Accessory",
                    "One Size",
                    "Green",
                    "Parakeet Green",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Leather",
                    "Luxury woven leather crossbody bag in a vivid color; designed as a statement accessory for fashion-forward outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Prada",
                    "Re-Nylon Shoulder Bag",
                    "Accessory",
                    "One Size",
                    "Black",
                    "Black",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Recycled Nylon, Saffiano Leather",
                    "Minimal luxury shoulder bag with technical nylon construction; suited to elevated streetwear and contemporary casual outfits.",
                    "2026-04-16",
                    5
            );

            addExisting(
                    repository,
                    "Gucci",
                    "GG Marmont Belt Bag",
                    "Accessory",
                    "One Size",
                    "Gold",
                    "Black / Antique Gold",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Leather, Metal",
                    "Luxury belt bag with prominent GG hardware; intended for statement casual outfits and hands-free carrying.",
                    "2025-12-18",
                    3
            );

            addExisting(
                    repository,
                    "New Era",
                    "New York Yankees 59FIFTY",
                    "Accessory",
                    "7 3/8",
                    "Blue",
                    "Navy / White",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Polyester",
                    "Structured fitted baseball cap with classic sports styling; useful for casual outfits, sun coverage, and streetwear.",
                    "2026-08-28",
                    51
            );

            addExisting(
                    repository,
                    "Nike",
                    "Dri-FIT Club Cap",
                    "Accessory",
                    "One Size",
                    "White",
                    "White / Black",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Polyester",
                    "Lightweight moisture-wicking cap designed for running, workouts, and hot-weather outdoor activity.",
                    "2026-08-25",
                    33
            );

            addExisting(
                    repository,
                    "Patagonia",
                    "Fisherman's Rolled Beanie",
                    "Accessory",
                    "One Size",
                    "Orange",
                    "Burnished Orange",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Recycled Polyester",
                    "Warm knit beanie suited to cold weather, casual outdoor use, commuting, and winter layering.",
                    "2026-02-27",
                    22
            );

            addExisting(
                    repository,
                    "Carhartt",
                    "Acrylic Watch Hat",
                    "Accessory",
                    "One Size",
                    "Yellow",
                    "Carhartt Gold",
                    "Fall/Winter",
                    "Everyday",
                    "Regular",
                    "Acrylic",
                    "Thick knit beanie designed for warmth during cold weather; practical for workwear, outdoor use, and casual winter outfits.",
                    "2026-01-19",
                    25
            );

            addExisting(
                    repository,
                    "Stussy",
                    "Stock Cuff Beanie",
                    "Accessory",
                    "One Size",
                    "Purple",
                    "Deep Purple",
                    "Fall/Winter",
                    "Casual",
                    "Regular",
                    "Acrylic",
                    "Streetwear knit beanie with simple embroidered branding; useful as a casual cold-weather accessory.",
                    "2026-03-11",
                    13
            );

            addExisting(
                    repository,
                    "Burberry",
                    "Classic Check Cashmere Scarf",
                    "Accessory",
                    "One Size",
                    "Multi",
                    "Archive Beige Check",
                    "Fall/Winter",
                    "Special Occasion",
                    "Regular",
                    "Cashmere",
                    "Soft luxury cashmere scarf providing warmth while adding a recognizable check pattern to formal and polished winter outfits.",
                    "2026-01-31",
                    9
            );

            addExisting(
                    repository,
                    "Acne Studios",
                    "Canada New Scarf",
                    "Accessory",
                    "One Size",
                    "Pink",
                    "Dusty Pink",
                    "Fall/Winter",
                    "Casual",
                    "Oversized",
                    "Wool",
                    "Large wool scarf with an oversized silhouette; useful for warmth and adding color to minimalist cold-weather outfits.",
                    "2026-02-16",
                    8
            );

            addExisting(
                    repository,
                    "Loro Piana",
                    "Grande Unita Cashmere Scarf",
                    "Accessory",
                    "One Size",
                    "Brown",
                    "Camel",
                    "Fall/Winter",
                    "Special Occasion",
                    "Regular",
                    "Cashmere",
                    "Refined lightweight cashmere scarf offering warmth without bulk; suited to tailoring, formal coats, and luxury winter outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Hermes",
                    "Carre 90 Silk Scarf",
                    "Accessory",
                    "90cm",
                    "Multi",
                    "Orange / Blue / Gold Print",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Silk",
                    "Printed silk scarf that can be worn around the neck, tied to a bag, or styled as a decorative accent for polished outfits.",
                    "2026-04-03",
                    4
            );

            addExisting(
                    repository,
                    "Levi's",
                    "Reversible Leather Belt",
                    "Accessory",
                    "32",
                    "Brown",
                    "Brown / Black",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Leather, Metal",
                    "Versatile reversible leather belt suitable for denim, chinos, and everyday casual outfits.",
                    "2026-08-23",
                    35
            );

            addExisting(
                    repository,
                    "Anderson's",
                    "Woven Elastic Belt",
                    "Accessory",
                    "90",
                    "Beige",
                    "Beige / Navy",
                    "Spring/Summer",
                    "Casual",
                    "Regular",
                    "Viscose, Rubber, Leather",
                    "Flexible woven belt with a relaxed smart-casual appearance; works well with chinos, shorts, and warm-weather outfits.",
                    "2026-07-10",
                    12
            );

            addExisting(
                    repository,
                    "Gucci",
                    "GG Marmont Leather Belt",
                    "Accessory",
                    "90",
                    "Black",
                    "Black / Gold",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Leather, Metal",
                    "Luxury leather belt with prominent double-G buckle; intended as a visible statement accessory in polished or designer outfits.",
                    "2026-03-22",
                    6
            );

            addExisting(
                    repository,
                    "Tiffany & Co.",
                    "Return to Tiffany Heart Tag Pendant",
                    "Accessory",
                    "One Size",
                    "Silver",
                    "Sterling Silver",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Sterling Silver",
                    "Polished silver pendant necklace with recognizable heart tag design; suited to everyday jewelry layering and special occasions.",
                    "2026-06-19",
                    10
            );

            addExisting(
                    repository,
                    "David Yurman",
                    "Cable Classics Bracelet",
                    "Accessory",
                    "M",
                    "Silver",
                    "Sterling Silver",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Sterling Silver",
                    "Textured cable bracelet with a refined but substantial appearance; useful for elevated casual and dressier outfits.",
                    "2026-05-07",
                    7
            );

            addExisting(
                    repository,
                    "Cartier",
                    "LOVE Bracelet",
                    "Accessory",
                    "17",
                    "Gold",
                    "Yellow Gold",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "18K Gold",
                    "Minimal luxury bracelet with a clean polished profile; designed for frequent wear and formal or elevated outfits.",
                    "2026-02-09",
                    5
            );

            addExisting(
                    repository,
                    "Maison Margiela",
                    "Numeric Logo Ring",
                    "Accessory",
                    "M",
                    "Silver",
                    "Polished Silver",
                    "All-Season",
                    "Casual",
                    "Regular",
                    "Sterling Silver",
                    "Minimal designer ring engraved with numeric branding; works well with understated contemporary and avant-garde outfits.",
                    "2026-07-01",
                    11
            );

            addExisting(
                    repository,
                    "Vivienne Westwood",
                    "Mini Bas Relief Choker",
                    "Accessory",
                    "One Size",
                    "Silver",
                    "Silver / Crystal",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Brass, Crystal",
                    "Decorative choker featuring the signature orb motif; suited to punk-inspired, dressy, and statement outfits.",
                    null,
                    0
            );

            addExisting(
                    repository,
                    "Chrome Hearts",
                    "CH Plus Stud Earring",
                    "Accessory",
                    "One Size",
                    "Silver",
                    "Sterling Silver",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Sterling Silver",
                    "Small gothic silver stud earring with distinctive cross motif; suited to darker streetwear and jewelry-focused outfits.",
                    "2026-04-28",
                    3
            );

            addExisting(
                    repository,
                    "Casio",
                    "G-Shock DW-5600",
                    "Accessory",
                    "One Size",
                    "Black",
                    "Black",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Resin, Mineral Glass",
                    "Durable digital watch with shock and water resistance; practical for workouts, outdoor activity, travel, and everyday use.",
                    "2026-08-27",
                    47
            );

            addExisting(
                    repository,
                    "Seiko",
                    "5 Sports Automatic",
                    "Accessory",
                    "One Size",
                    "Blue",
                    "Blue Dial / Silver Bracelet",
                    "All-Season",
                    "Everyday",
                    "Regular",
                    "Stainless Steel, Hardlex",
                    "Versatile automatic sports watch with enough durability for daily wear while remaining polished enough for smart-casual outfits.",
                    "2026-08-17",
                    24
            );

            addExisting(
                    repository,
                    "Omega",
                    "Seamaster Diver 300M",
                    "Accessory",
                    "One Size",
                    "Blue",
                    "Blue / Silver",
                    "All-Season",
                    "Special Occasion",
                    "Regular",
                    "Stainless Steel, Ceramic, Sapphire",
                    "Luxury dive watch with strong water resistance and a sporty polished appearance; works with casual, travel, and dressier outfits.",
                    "2026-03-06",
                    6
            );

            addExisting(
                    repository,
                    "Ray-Ban",
                    "Original Wayfarer Classic",
                    "Accessory",
                    "50mm",
                    "Black",
                    "Black / Green Lens",
                    "Spring/Summer",
                    "Everyday",
                    "Regular",
                    "Acetate, Glass",
                    "Classic square sunglasses providing sun protection with a versatile casual silhouette that works across many warm-weather outfits.",
                    "2026-08-21",
                    27
            );

            addExisting(
                    repository,
                    "Oakley",
                    "Radar EV Path",
                    "Accessory",
                    "One Size",
                    "White",
                    "Polished White / Prizm Road",
                    "Spring/Summer",
                    "Casual",
                    "Slim",
                    "O Matter, Polycarbonate",
                    "Wraparound performance sunglasses designed for running, cycling, hiking, and other bright high-output outdoor activities.",
                    "2026-08-13",
                    19
            );

            addExisting(
                    repository,
                    "Gentle Monster",
                    "Maison Margiela MM004 Sunglasses",
                    "Accessory",
                    "One Size",
                    "Gray",
                    "Gray Transparent",
                    "Spring/Summer",
                    "Special Occasion",
                    "Oversized",
                    "Acetate, Nylon Lens",
                    "Oversized designer sunglasses with a futuristic silhouette; intended as a statement accessory for contemporary outfits.",
                    "2026-06-12",
                    5
            );

            addExisting(
                    repository,
                    "The North Face",
                    "Etip Recycled Gloves",
                    "Accessory",
                    "M",
                    "Black",
                    "Black",
                    "Fall/Winter",
                    "Everyday",
                    "Slim",
                    "Recycled Polyester, Elastane",
                    "Lightweight touchscreen-compatible gloves providing warmth for commuting, walking, and cool-weather outdoor activity.",
                    "2026-02-22",
                    17
            );

            addExisting(
                    repository,
                    "Smartwool",
                    "Cozy Grip Gloves",
                    "Accessory",
                    "M",
                    "Gray",
                    "Charcoal Gray",
                    "Fall/Winter",
                    "Casual",
                    "Slim",
                    "Merino Wool, Polyester",
                    "Warm merino-blend gloves suited to hiking, walking, and cold-weather layering while retaining good dexterity.",
                    "2026-01-14",
                    13
            );

            addExisting(
                    repository,
                    "Brooks Brothers",
                    "Repp Stripe Silk Tie",
                    "Accessory",
                    "One Size",
                    "Red",
                    "Burgundy / Navy Stripe",
                    "All-Season",
                    "Special Occasion",
                    "Slim",
                    "Silk",
                    "Classic striped silk tie suited to suits, interviews, professional settings, weddings, and other formal occasions.",
                    "2026-05-18",
                    8
            );

            System.out.println("Database seeded successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a sample existing wardrobe piece with wear history.
     */
    private static void addExisting(
            PieceRepository repository,
            String brand,
            String name,
            String category,
            String size,
            String color,
            String colorway,
            String season,
            String occasion,
            String fit,
            String materials,
            String notes,
            String lastWorn,
            int timesWorn
    ) throws Exception {

        Piece piece = Piece.existing(
                brand,
                name,
                category,
                size,
                color,
                colorway,
                season,
                occasion,
                fit,
                materials,
                notes,
                lastWorn,
                timesWorn
        );

        repository.addExistingPiece(piece);
    }
}