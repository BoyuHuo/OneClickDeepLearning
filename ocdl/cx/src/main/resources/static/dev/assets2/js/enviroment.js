const enviorment = {
    API:{
        /*------ Jupyter service resource---------*/
        JUPYTER_SERVER: '/rest/container/type',
        DELETE_SERVER: '/rest/container/release',

        /*------ Auth service resource---------*/
        LOGIN_PWD: '/rest/auth/login?pwd',
        LOGIN_OAUTH:'/rest/auth/login?oauth',
        LOGOUT: '/rest/auth/logout',
        REGISTER: '/rest/auth/signup',
        USER_INFO_BY_TOKEN: '/rest/auth/me',

        /*------ Template service resource---------*/
        TEMPLATE_LIST: '/rest/template/file',
        TEMPLATE_CODE: '/rest/template/code',

        /*------ Model service resource---------*/
        MODEL:'/rest/model',
        MODEL_PUSH: '/rest/model',
        MODEL_TYPE: '/rest/project/algorithm',

        /*------ Configure service resource---------*/
        PROJECT: '/rest/project/config',
        PROJECT_NAME: '/rest/project/config/name',
        PROJECT_UPDATE: '/rest/project/config',

        /* ------- Upload  ---------*/
        UPLOAD:'/rest/project/data'
    }
};