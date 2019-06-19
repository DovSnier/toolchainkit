#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import com.dvsnier.support.presenter.SupportFragmentPresenter;

#parse("MVP File Header.java")
public class ${NAME} extends SupportFragmentPresenter<${Activity_Name}> {

    public void request() {
        // TODO: ${DATE}
    }
}
