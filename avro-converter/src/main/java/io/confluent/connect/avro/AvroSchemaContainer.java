package io.confluent.connect.avro;

import org.apache.avro.Schema;

public class AvroSchemaContainer {

    private Schema schema;

    public AvroSchemaContainer(Schema schema) {
        assert (schema != null);
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvroSchemaContainer that = (AvroSchemaContainer) o;

        return schema.equals(that.schema); // costly operation when the schemas are huge
    }

    @Override
    public int hashCode() {
        Schema.Type type = schema.getType();
        String name = schema.getName();
        String doc = schema.getDoc();

        int result = (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (doc != null ? doc.hashCode() : 0);

        return result;
    }

    public Schema getSchema() {
        return schema;
    }
}
