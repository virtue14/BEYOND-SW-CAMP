import {createRouter, createWebHashHistory} from "vue-router";
import HomeView from "@/views/01_router/HomeView.vue";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            component: HomeView
        }
    ]
});

/* router 객체를 export함(main.js에서 import할 용도) */
export default router;
