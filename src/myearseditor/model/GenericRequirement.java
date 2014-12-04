/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myearseditor.model;

/**
 *
 * @author Krish
 *Req Syntax : <optional preconditions> <optional trigger> the <system name> shall <system response> */
public class GenericRequirement extends EARSRequirement{
    private String _reqOptionalPreCond;
    private String _reqOptionalTrigger;
    private String _reqSysName;
    private String _reqSysResponse;

    public GenericRequirement(String opCond,String opTrig,String sName, String sResp,String rCCode, String rIndex){
        super("Generic",rCCode,rIndex);
        this._reqOptionalPreCond = opCond;
        this._reqOptionalTrigger = opTrig;
        this._reqSysName = sName;
        this._reqSysResponse = sResp;
    }
    
    public GenericRequirement(){
        super("Generic");
    }
    public String getReqOptionalPreCond() {
        return _reqOptionalPreCond;
    }

    public String getReqOptionalTrigger() {
        return _reqOptionalTrigger;
    }

    public String getReqSysName() {
        return _reqSysName;
    }

    public String getReqSysResponse() {
        return _reqSysResponse;
    }

    public void setReqOptionalPreCond(String _reqOptionalPreCond) {
        this._reqOptionalPreCond = _reqOptionalPreCond;
    }

    public void setReqOptionalTrigger(String _reqOptionalTrigger) {
        this._reqOptionalTrigger = _reqOptionalTrigger;
    }

    public void setReqSysName(String _reqSysName) {
        this._reqSysName = _reqSysName;
    }

    public void setReqSysResponse(String _reqSysResponse) {
        this._reqSysResponse = _reqSysResponse;
    }
    
}
