package devises_1290.a10.dal;

public class SQL_BOX {

    public static final String FIND_CURRENCY_BY_NAME = """ 
               SELECT *
               FROM Currency C
               WHERE C.name = ?
               """;
    public static final String ADD_RATE = """ 
            INSERT INTO Rate (value, id_currency)
            VALUES
            (?, ?)
            """;
    public static final String FIND_RATE_BY_CURRENCY_NAME = """ 
            SELECT r.*
            FROM Rate r
            JOIN Currency c ON r.id_currency = c.id
            WHERE c.name = ?
            """;
}
