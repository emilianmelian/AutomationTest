package com.tools.data.salesOnSpeed;

public class Not_interested {
	  private String value;

	    private String label;

	    private String type;

	    private String disabled;

	    public String getValue ()
	    {
	        return value;
	    }

	    public void setValue (String value)
	    {
	        this.value = value;
	    }

	    public String getLabel ()
	    {
	        return label;
	    }

	    public void setLabel (String label)
	    {
	        this.label = label;
	    }

	    public String getType ()
	    {
	        return type;
	    }

	    public void setType (String type)
	    {
	        this.type = type;
	    }

	    public String getDisabled ()
	    {
	        return disabled;
	    }

	    public void setDisabled (String disabled)
	    {
	        this.disabled = disabled;
	    }

	    @Override
	    public String toString()
	    {
	        return "Not_interested [value = "+value+", label = "+label+", type = "+type+", disabled = "+disabled+"]";
	    }
}
