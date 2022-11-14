package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper(){
    }

    @SneakyThrows
    private static Connection getConn(){
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static String getOrderID(){
        var request = "SELECT payment_id FROM order_entity ORDER BY created DESC LIMIT 1";
        try (var conn = getConn()) {
            var result = runner.query(conn, request, new ScalarHandler<String>());
            return result;
        }
    }

    @SneakyThrows
    public static String getTransactionID(){
        var request = "SELECT transaction_id FROM payment_entity ORDER BY created DESC LIMIT 1";
        try (var conn = getConn()) {
            var result = runner.query(conn, request, new ScalarHandler<String>());
            return result;
        }
    }

    @SneakyThrows
    public static String getStatus(){
        var request = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        try (var conn = getConn()) {
            var result = runner.query(conn, request, new ScalarHandler<String>());
            return result;
        }
    }

    @SneakyThrows
    public static void cleanDatabase(){
        var connection = getConn();
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM credit_request_entity");
    }
}
