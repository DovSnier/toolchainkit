#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import com.dvsnier.common.compat.ICompatBaseView;
import com.dvsnier.common.view.BaseCompatFragment;

#parse("MVP File Header.java")
public class ${NAME} extends BaseCompatFragment<${Presenter_Name}> implements ICompatBaseView {

    @Override
    public void initView() {
        // TODO: ${DATE}
    }

    @Override
    public void initData() {
        // TODO: ${DATE}
    }
}
