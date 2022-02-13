package com.Inter.demo.database.books.service;

/**
 * The enum Sql querty.
 */
public enum SqlQuerty {
    /**
     * The Get.
     */
    get {
        public String sql() {
            return "select * from " + TABLE_NAME;
        }
    },
    /**
     * The Get by.
     */
    get_by{
        public String sql() {
            return "select * from " + TABLE_NAME + "where ";
        }
    },
    /**
     * The Delete.
     */
    delete{
        public String sql() {
            return "delete from " + TABLE_NAME + "where ";
        }
    },
    /**
     * The Insert.
     */
    insert{
        public String sql() {
            return "insert into " + TABLE_NAME;
        }
    },
    /**
     * The Update.
     */
    update{
        public String sql() {
            return "update " + TABLE_NAME + "set ";
        }
    };

    /**
     * Sql string.
     *
     * @return the string
     */
    public abstract String sql();

    private static final String TABLE_NAME = "books ";
}
