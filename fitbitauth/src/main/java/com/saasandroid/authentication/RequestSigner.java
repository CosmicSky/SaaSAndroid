package com.saasandroid.authentication;

import com.saasandroid.fitbitcommon.network.BasicHttpRequestBuilder;

/**
 * Created by jboggess on 9/26/16.
 */

public interface RequestSigner {

    void signRequest(BasicHttpRequestBuilder builder);

}
