package com.calypso.library.rx.retrofit.func;


import com.mrym.common.rx.json.JsonConvert;
import com.mrym.common.rx.retrofit.HttpResult;

import rx.functions.Func1;

/**
 * Created by Jian on 2016/12/16.
 * Email: 798774875@qq.com
 * Github: https://github.com/moruoyiming
 */
public class ResultFunc<T> implements Func1<String, HttpResult<T>> {
    @Override
    public HttpResult<T> call(String result) {
        JsonConvert<HttpResult<T>> convert = new JsonConvert<HttpResult<T>>() {
        };
        return convert.parseData(result);
    }
}
