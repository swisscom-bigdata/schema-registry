package io.confluent.connect.avro;

import org.apache.avro.Schema;

import java.util.Objects;

public class AvroSchemaWrapper {

    private Schema schema;

    public AvroSchemaWrapper(Schema schema) {
        assert (schema != null);
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvroSchemaWrapper that = (AvroSchemaWrapper) o;

        return schema.equals(that.schema); // costly operation when the schemas are huge
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema.getType(), schema.getName(), schema.getDoc());
    }

    public Schema getSchema() {
        return schema;
    }
}
