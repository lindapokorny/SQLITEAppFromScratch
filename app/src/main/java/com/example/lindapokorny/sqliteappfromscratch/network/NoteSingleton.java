package com.example.lindapokorny.sqliteappfromscratch.network;

import com.example.lindapokorny.sqliteappfromscratch.model.Note;

//3)We created a singleton for subclassed SQLITE helper instance

public class NoteSingleton {
    private static Note instance;

    private NoteSingleton(){}
        public static Note getInstance() {
            if (instance != null) {
                return instance;
            }
            return instance;
        }

}
