package com.Inter.demo.database.books.service;

public enum SqlQuerty {
    get {
        public String sql() {
            return "select * from " + TABLE_NAME;
        }
    },
    get_by{
        public String sql() {
            return "select * from " + TABLE_NAME + "where ";
        }
    }, delete{
        public String sql() {
            return "delete from " + TABLE_NAME + "where ";
        }
    }, insert{
        public String sql() {
            return "insert into " + TABLE_NAME;
        }
    }, update{
        public String sql() {
            return "update " + TABLE_NAME + "set ";
        }
    };

    public abstract String sql();

    private static final String TABLE_NAME = "books ";
}
