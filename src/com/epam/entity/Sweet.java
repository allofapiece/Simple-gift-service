package com.epam.entity;

/**
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Sweet extends EdibleProduct {
    private SweetType type;

    public SweetType getType() {
        return type;
    }

    public void setType(SweetType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Sweet that = (Sweet) o;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "type = " + type + '\n';
    }
}
