/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.bjf.remoting.protobuf.complexList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class ListWithNull.
 *
 * @author xiemalin
 * @since 1.10.9
 */
public class ListWithNull {
    
    @Protobuf(fieldType = FieldType.STRING)
    public List<String> list;

    
    public static void main(String[] args) throws IOException {
        
        ListWithNull obj = new ListWithNull();
        
        List<String> list = new ArrayList<String>();
        list.add("abc");
        obj.list = list;
        
        Codec<ListWithNull> codec = ProtobufProxy.create(ListWithNull.class, true);
        
        byte[] encode = codec.encode(obj);
        System.out.println(Arrays.toString(encode));
        
        list.add(null);
        encode = codec.encode(obj);
        System.out.println(Arrays.toString(encode));
        
        ListWithNull decode = codec.decode(encode);
        System.out.println(decode.list);
    }
}
