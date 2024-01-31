// This file is the starting point of the whole app.
package com.napier.team4;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Connect to MYSQL
        MYSQLConnection mysqlCon = new MYSQLConnection();
        mysqlCon.connect();
        mysqlCon.disconnect();
    }
}
