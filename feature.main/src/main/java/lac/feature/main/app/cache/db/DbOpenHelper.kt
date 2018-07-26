package lac.feature.main.app.cache.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build

class DbOpenHelper(val context: Context) : SQLiteOpenHelper(context,
                                                            DATABASE_NAME,
                                                            null,
                                                            DATABASE_VERSION) {

    companion object {
        val DATABASE_NAME = "pdp.db"
        val DATABASE_VERSION = 1
    }

    override fun onConfigure(db: SQLiteDatabase) {
        super.onConfigure(db)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            db.setForeignKeyConstraintsEnabled(true)
        } else {
            db.execSQL("PRAGMA foreign_keys=ON;")
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.beginTransaction()
        try {
            db.execSQL(Db.BookmarkTable.CREATE)
            db.execSQL(Db.CitiesTable.CREATE)
            db.execSQL(Db.ProvidersTable.CREATE)
            db.execSQL(Db.FeedsTable.CREATE)
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}