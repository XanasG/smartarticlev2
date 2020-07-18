import React from "react";
import { Redirect } from "react-router-dom";

// Layout Types
import { DefaultLayout } from "./layouts";

// Route Views
import Dashboard from "./views/Dashboard";
//import UserProfileLite from "./views/UserProfile";
import Errors from "./views/Errors";

export default [
  {
    path: "/",
    exact: true,
    layout: DefaultLayout,
    component: () => <Redirect to="/dashboard" />
  },
  {
    path: "/dashboard",
    layout: DefaultLayout,
    component: Dashboard
  },
  /*{
    path: "/user-profile",
    layout: DefaultLayout,
    component: UserProfile
  },*/
  {
    path: "/errors",
    layout: DefaultLayout,
    component: Errors
  }
];
