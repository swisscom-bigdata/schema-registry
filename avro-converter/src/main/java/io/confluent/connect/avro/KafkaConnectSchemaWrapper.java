package io.confluent.connect.avro;


import org.apache.kafka.connect.data.Schema;

import java.util.Objects;

public class KafkaConnectSchemaWrapper {

    private Schema schema;

    public KafkaConnectSchemaWrapper(Schema schema) {
        assert (schema != null);
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KafkaConnectSchemaWrapper that = (KafkaConnectSchemaWrapper) o;

        String name1 = schema.name();
        String name2 = that.schema.name();
        Integer version1 = schema.version();
        Integer version2 = that.schema.version();

        if (name1 != null && name2 != null && version1 != null && version2 != null) {
            // HACK: two schemas are identical when their name and version equal.
            return Objects.equals(schema.name(), that.schema.name()) && Objects.equals(schema.version(), that.schema.version());
        }

        return schema.equals(that.schema);
    }

    @Override
    public int hashCode() {
        String name = schema.name();
        Integer version = schema.version();

        if (name != null && version != null) {
            return Objects.hash(name, version);
        }

        return schema.hashCode();
    }

    public Schema getSchema() {
        return schema;
    }
}
