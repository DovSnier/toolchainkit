#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import com.dvsnier.support.presenter.SupportPresenter;

#parse("MVP File Header.java")
public class ${NAME} extends SupportPresenter<${Activity_Name}> {

    public void request() {
        // TODO: ${DATE}
    }
}
