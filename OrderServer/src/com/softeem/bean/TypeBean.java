package com.softeem.bean;

public class TypeBean {
	private int typeId;
	private String typeName;
	private int typeParentId;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeParentId() {
		return typeParentId;
	}

	public void setTypeParentId(int typeParentId) {
		this.typeParentId = typeParentId;
	}

	@Override
	public String toString() {
		return "TypeBean [typeId=" + typeId + ", typeName=" + typeName + ", typeParentId=" + typeParentId + "]";
	}

}
