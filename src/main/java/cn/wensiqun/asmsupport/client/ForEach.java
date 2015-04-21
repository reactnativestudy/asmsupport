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
package cn.wensiqun.asmsupport.client;

import cn.wensiqun.asmsupport.client.def.var.LocVar;
import cn.wensiqun.asmsupport.core.block.control.loop.ForEachInternal;
import cn.wensiqun.asmsupport.core.clazz.AClassFactory;
import cn.wensiqun.asmsupport.core.definition.variable.LocalVariable;
import cn.wensiqun.asmsupport.standard.def.clazz.AClass;
import cn.wensiqun.asmsupport.standard.loop.IForEach;

public abstract class ForEach extends ProgramBlock<ForEachInternal> implements IForEach<LocVar> {

	public ForEach(Param iteratorVar) {
		target = new ForEachInternal(iteratorVar.getTarget()) {

			@Override
			public void body(LocalVariable e) {
				ForEach.this.body(new LocVar(e));
			}
			
		};
	}
	
    public ForEach(Param iteratorVar, AClass elementType) {
        target = new ForEachInternal(iteratorVar.getTarget(), elementType) {

            @Override
            public void body(LocalVariable e) {
                ForEach.this.body(new LocVar(e));
            }
            
        };
    }
    
    public ForEach(Param iteratorVar, Class<?> elementType) {
        target = new ForEachInternal(iteratorVar.getTarget(), AClassFactory.getType(elementType)) {

            @Override
            public void body(LocalVariable e) {
                ForEach.this.body(new LocVar(e));
            }
            
        };
    }
	
}
