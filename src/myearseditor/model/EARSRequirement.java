/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myearseditor.model;

/**
 *
 * @author Krish
 */
public abstract class EARSRequirement{
    private String _reqId;
    private String _reqType;
    
    public enum ColorCode{ 
        RED("Red"), GREY("Grey"), GREEN("Green"); 
        private String colour;
        ColorCode(String colour) {
            this.colour = colour;
        }
        public String toString(){
            return this.colour;
        }
    };
    private ColorCode _reqColorCode;
    
    public void setReqId(String _reqId) {
        this._reqId = _reqId;
    }
    
    public String getReqId() {
        return _reqId;
    }

    public String getReqColorCode() {
        return _reqColorCode.toString();
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
    
    public EARSRequirement(String _rType,String rCCode,String rIndex){
    	this._reqType = _rType;
        this._reqId = rIndex;
        switch(rCCode)
        { case "Red" : this._reqColorCode = ColorCode.RED; break;
          case "Green" : this._reqColorCode = ColorCode.GREEN; break;
          case "Grey" : this._reqColorCode = ColorCode.GREY; break;    
        }
    }
}
