package com.alibaba.fescar.samples.tcc.transfer.action;

import com.alibaba.fescar.rm.tcc.api.BusinessActionContext;
import com.alibaba.fescar.rm.tcc.api.BusinessActionContextParameter;
import com.alibaba.fescar.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * TCC参与者：加钱
 *
 * @author zhangsen
 */
public interface SecondTccAction {

	 /**
     * 一阶段方法
     * 
     * @param businessActionContext
     * @param accountNo
     * @param amount
     */
    @TwoPhaseBusinessAction(name = "secondTccAction", commitMethod = "commit", rollbackMethod = "rollback")
    public boolean prepareAdd(BusinessActionContext businessActionContext,
                              @BusinessActionContextParameter(paramName = "accountNo") String accountNo,
                              @BusinessActionContextParameter(paramName = "amount") double amount);

    /**
     * 二阶段提交
     * @param businessActionContext
     * @return
     */
    public boolean commit(BusinessActionContext businessActionContext);

    /**
     * 二阶段回滚
     * @param businessActionContext
     * @return
     */
    public boolean rollback(BusinessActionContext businessActionContext);

}
