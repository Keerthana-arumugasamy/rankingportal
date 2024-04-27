import Backend from "../../config/Backend";
import { AxiosError, AxiosResponse } from "axios";
import React, {createContext, useReducer} from "react";
import {
    AdminListAction, adminListReducer,
    AdminListState, initialAdminListState,
} from "./reducer";
import StudentDTO from "../../dtos/StudentDTO";
import FacultyDTO from "../../dtos/FacultyDTO";

const AdminListContext = createContext<{
    state: AdminListState;
    dispatch: React.Dispatch<AdminListAction>;
    getAdminList :() => Promise<void>;
}>(
    {
    state: initialAdminListState,
    dispatch: () => null,
        getAdminList: () => Promise.resolve(),
    }
);

export const useAdminListContext = () => React.useContext(AdminListContext);

export const AdminListProvider = (
    {children,
    }: {
    children: React.ReactNode;
}) => {

    const [state,dispatch] = useReducer(adminListReducer, initialAdminListState);

    const getAdminList = () => {
        return new Promise<void>((resolve, reject) => {
            dispatch({ type: "SET_LOADING", payload: true });
            Backend.AdminList.list()
                .then((response: AxiosResponse) => {
                    dispatch({ type: "SET_ADMIN_LIST", payload: response.data });
                    resolve();
                })
                .catch((error: AxiosError) => reject(error))
                .finally(() => dispatch({ type: "SET_LOADING", payload: false }));
        });
    };

    return (
        <AdminListContext.Provider
            value={{
                state,
                dispatch,
                getAdminList,
            }}
        >
            {children}
        </AdminListContext.Provider>
    );
};