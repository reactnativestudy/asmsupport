/**    
 *  Asmsupport is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cn.wensiqun.asmsupport.core.operator.method;

import cn.wensiqun.asmsupport.core.context.MethodExecuteContext;
import cn.wensiqun.asmsupport.core.block.KernelProgramBlock;
import cn.wensiqun.asmsupport.core.definition.KernelParam;
import cn.wensiqun.asmsupport.core.utils.log.Log;
import cn.wensiqun.asmsupport.core.utils.log.LogFactory;
import cn.wensiqun.asmsupport.org.objectweb.asm.Type;
import cn.wensiqun.asmsupport.standard.def.clazz.IClass;
import cn.wensiqun.asmsupport.utils.Modifiers;

/**
 * Represent a static method call
 * 
 * @author wensiqun at 163.com(Joe Wen)
 */
public class StaticMethodInvoker extends MethodInvoker {

    private static final Log LOG = LogFactory.getLog(StaticMethodInvoker.class);
    
    protected StaticMethodInvoker(KernelProgramBlock block, IClass owner, String name,
            KernelParam[] arguments) {
        super(block, owner, name, arguments);
        if (owner.isPrimitive()) {
            throw new IllegalArgumentException("Cannot call static method from primitive");
        }
        setSaveReference(false);
    }
    
    @Override
	protected void initAdditionalProperties() {
		super.initAdditionalProperties();
		if(!Modifiers.isStatic(methodMeta.getModifiers())){
			throw new IllegalArgumentException("\"" + methodMeta.toString() + "\" is not a static method ");
		}
	}

	@Override
    public void doExecute(MethodExecuteContext context) {
        argumentsToStack(context);
        LOG.print("invoke static method : " + name);
        context.getInstructions().invokeStatic(methodOwner.getType(), name, getReturnType(), methodMeta.getParameterAsmTypes());
        if(!isSaveReference()){
            if(!getReturnType().equals(Type.VOID_TYPE)){
                context.getInstructions().pop();
            }
        }
    }

    @Override
    public String toString() {
        return methodOwner + "." + methodMeta;
    }


}
