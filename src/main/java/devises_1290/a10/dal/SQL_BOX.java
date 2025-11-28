package devises_1290.a10.dal;

public class SQL_BOX {

    public static final String FIND_CURRENCY_BY_NAME = """ 
               SELECT *
               FROM Currency C
               WHERE C.name = ?
               """;
    public static final String FIND_CURRENCY_BY_NAME_JPA = """ 
               SELECT c
               FROM Currency c
               WHERE c.name = :name
               """;
    public static final String UPDATE_RATE = """ 
            UPDATE Rate
            SET rate_value = ?
            WHERE id_currency = ?
            """;
    public static final String UPDATE_RATE_JPA = """ 
            UPDATE Rate
            SET rate_value = :rate_value
            WHERE id_currency = :id_currency
            """;
    public static final String FIND_RATE_BY_CURRENCY_NAME = """ 
            SELECT *
            FROM Rate r
            JOIN Currency c ON r.id_currency = c.id
            WHERE c.name = ?
            """;

    public static final String FIND_RATE_BY_CURRENCY_NAME_JPA = """ 
            SELECT r
            FROM Rate r
            JOIN r.currency c
            WHERE c.name = :name
    """;

}
