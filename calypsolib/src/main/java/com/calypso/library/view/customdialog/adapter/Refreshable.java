package com.calypso.library.view.customdialog.adapter;

import java.util.List;

/**
 * Created by Administrator on 2016/5/10 0010.
 */
public interface Refreshable {
    public void refresh(List newData);

    public void addAll(List newData);

    public void clear();

    public void delete(int position);

    public void add(Object object);
}
