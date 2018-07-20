#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dvsnier.base.view.ICompatV1BaseView;
import com.dvsnier.support.view.SupportActivity;

#parse("MVP File Header.java")
public class ${NAME} extends SupportActivity<${Presenter_Name}> implements ICompatV1BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: ${DATE} ${NAME}
        setContentView(R.layout.activity_XXX);
        initView();
        initData();
    }

    @Override
    public void initView() {
        // TODO: ${DATE}
    }

    @Override
    public void initData() {
        // TODO: ${DATE}
    }
}