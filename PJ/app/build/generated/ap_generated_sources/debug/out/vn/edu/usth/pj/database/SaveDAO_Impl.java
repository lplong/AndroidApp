package vn.edu.usth.pj.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import vn.edu.usth.pj.Save_Page;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SaveDAO_Impl implements SaveDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Save_Page> __insertionAdapterOfSave_Page;

  private final EntityDeletionOrUpdateAdapter<Save_Page> __deletionAdapterOfSave_Page;

  public SaveDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSave_Page = new EntityInsertionAdapter<Save_Page>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Saved` (`id`,`title`,`desc`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Save_Page value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDesc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDesc());
        }
      }
    };
    this.__deletionAdapterOfSave_Page = new EntityDeletionOrUpdateAdapter<Save_Page>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Saved` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Save_Page value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insertAll(final Save_Page save_page) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSave_Page.insert(save_page);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Save_Page save_page) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSave_Page.handle(save_page);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Save_Page> getAll() {
    final String _sql = "SELECT * FROM Saved";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
      final List<Save_Page> _result = new ArrayList<Save_Page>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Save_Page _item;
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpDesc;
        _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
        _item = new Save_Page(_tmpTitle,_tmpDesc);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Save_Page> loadAllByIds(final int[] Saved_int) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM Saved WHERE id IN (");
    final int _inputSize = Saved_int.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : Saved_int) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
      final List<Save_Page> _result = new ArrayList<Save_Page>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Save_Page _item_1;
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpDesc;
        _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
        _item_1 = new Save_Page(_tmpTitle,_tmpDesc);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item_1.setId(_tmpId);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
