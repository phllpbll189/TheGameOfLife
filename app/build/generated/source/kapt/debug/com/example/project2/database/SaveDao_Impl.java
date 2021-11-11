package com.example.project2.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SaveDao_Impl implements SaveDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SavedGrid> __insertionAdapterOfSavedGrid;

  private final GridTypeConverters __gridTypeConverters = new GridTypeConverters();

  public SaveDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSavedGrid = new EntityInsertionAdapter<SavedGrid>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `SavedGrid` (`name`,`lifeList`,`id`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SavedGrid value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        final String _tmp;
        _tmp = __gridTypeConverters.toLifeListJson(value.getLifeList());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = __gridTypeConverters.fromUUID(value.getId());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp_1);
        }
      }
    };
  }

  @Override
  public void addGrid(final SavedGrid Grid) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSavedGrid.insert(Grid);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<SavedGrid>> getSaves() {
    final String _sql = "SELECT * FROM SavedGrid";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"SavedGrid"}, false, new Callable<List<SavedGrid>>() {
      @Override
      public List<SavedGrid> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLifeList = CursorUtil.getColumnIndexOrThrow(_cursor, "lifeList");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<SavedGrid> _result = new ArrayList<SavedGrid>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SavedGrid _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final List<Boolean> _tmpLifeList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfLifeList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfLifeList);
            }
            _tmpLifeList = __gridTypeConverters.toLifeList(_tmp);
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __gridTypeConverters.toUUID(_tmp_1);
            _item = new SavedGrid(_tmpName,_tmpLifeList,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
