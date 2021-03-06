/**
 * Copyright 2017 Hortonworks.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package com.hortonworks.registries.schemaregistry.serdes.avro.kafka;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Created by Ricker on 4/18/2017.
 */
public class KafkaAvroSerde implements Serde<Object> {

    private Serializer ser = new KafkaAvroSerializer();
    private Deserializer deser = new KafkaAvroDeserializer();

    public void configure(Map<String, ?> configs, boolean isKey) {
        ser.configure(configs,isKey);
        deser.configure(configs,isKey);
    }

    public void close(){
        ser.close();
        deser.close();
    }

    public Serializer<Object> serializer() {
        return ser;
    }

    public Deserializer<Object> deserializer() {
        return deser;
    }
}
