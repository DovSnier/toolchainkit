#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import com.dvsnier.common.compat.ICompatBaseView;
import com.dvsnier.support.view.SupportFragment;

#parse("MVP File Header.java")
public class ${NAME} extends SupportFragment<${Presenter_Name}> implements ICompatBaseView {

    @Override
    public void initView() {
        // TODO: ${DATE}
    }

    @Override
    public void initData() {
        // TODO: ${DATE}
    }
}
