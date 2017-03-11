package com.calypso.library.rx.json;

/**
 * Created by Jian on 2016/12/16.
 * Email: 798774875@qq.com
 * Github: https://github.com/moruoyiming
 */
public abstract class AbsConvert<T> {

    abstract T parseData(String result);
}
