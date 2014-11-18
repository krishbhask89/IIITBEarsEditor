/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.Model;

/**
 *
 * @author Krish
 */
public abstract class EARSRequirement {
    private long _reqId;
    private String _reqType;
    enum ColorCode{ RED, GREY, GREEN};
    private ColorCode _reqColorCode;
    
    public void setReqId(long _reqId) {
        this._reqId = _reqId;
    }

    public void setReqType(String _reqType) {
        this._reqType = _reqType;
    }

    public String getReqType() {
        return _reqType;
    }
    
    public EARSRequirement(String _rType){
    	this._reqColorCode = ColorCode.RED;
    	this._reqType = _rType;
    }
}
