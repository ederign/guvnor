package org.drools.brms.client.rpc;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * This is a row of data from a table.
 * @author michael neale
 *
 */
public class TableDataRow
    implements
    IsSerializable {

    /**
     * The unique ID for the resource.
     * Most likely a UUID
     */
    public String id;
    
    /**
     * The type of resource (eg DRL rule, business rule etc).
     * This will determine what sort of editor opens it.
     */
    public String format;    
    
    /** 
     * The actual values to display
     * We will assume that the first one is the display name when opening. 
     */
    public String[] values;
    
    public String getDisplayName() {
        return values[0];    
    }

    /**
     * Returns a key that can be used to drive an "open" event.
     * Use getId and getType to break it apart.
     */
    public String getKeyValue() {
        return id + "," + format;
    }
    
    /**
     * Gets the ID from the key value.
     */
    public static String getId(String key) {
        return key.split( "\\," )[0];
    }

    /**
     * Gets the format from the keyvalue
     */
    public static String getFormat(String key) {
        return key.split( "\\," )[1];
    }
    
}
