package cn.wensiqun.asmsupport.client.def.action;

import cn.wensiqun.asmsupport.client.def.Param;
import cn.wensiqun.asmsupport.client.def.param.basic.DummyParam;
import cn.wensiqun.asmsupport.core.operator.Operator;
import cn.wensiqun.asmsupport.core.utils.common.BlockTracker;

public class PostIncAction extends AbstractUnaryAction {

    public PostIncAction(BlockTracker tracker) {
        super(tracker, Operator.POS_INC);
    }

    @Override
    public Param doAction(Param... operands) {
        return new DummyParam(tracker, tracker.track().postinc(operands[0].getTarget()));
    }

}
