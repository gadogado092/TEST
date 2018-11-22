package amat.juragankost

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper (ctx: Context) : ManagedSQLiteOpenHelper (ctx, DBjuragankost.DB_NAME, null,1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {

        db?.createTable(DBjuragankost.TABLE_OWNER,true,
            DBjuragankost.ID_OWNER to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                      DBjuragankost.NAME_OWNER to TEXT,
                      DBjuragankost.HP_OWNER to TEXT,
                      DBjuragankost.EMAIL_OWNER to TEXT )

        db?.createTable(DBjuragankost.TABLE_ROOM,true,
            DBjuragankost.ID_ROOM to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                      DBjuragankost.NAME_ROOM to TEXT,
                      DBjuragankost.ID_TIPE to INTEGER + DEFAULT("0"),
                      DBjuragankost.ID_TENANT to INTEGER + DEFAULT("0")
        )


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }



}