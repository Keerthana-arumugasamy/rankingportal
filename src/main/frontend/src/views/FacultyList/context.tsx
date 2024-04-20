import Backend from "../../config/Backend";
import { AxiosError, AxiosResponse } from "axios";
import React, {createContext, useReducer} from "react";
import { FacultyListAction, facultyListReducer, FacultyListState, initialFacultyListState,} from "./reducer";
import StudentDTO from "../../dtos/StudentDTO";
import FacultyDTO from "../../dtos/FacultyDTO";

const FacultyListContext = createContext<{
    state: FacultyListState;
    dispatch: React.Dispatch<FacultyListAction>;
    getFacultyList :() => Promise<void>;
    updateFacultyList:(data:FacultyDTO) => Promise<void>;
}>(
    {
    state: initialFacultyListState,
    dispatch: () => null,
        getFacultyList: () => Promise.resolve(),
        updateFacultyList: () => Promise.resolve(),
    }
);

export const useFacultyListContext = () => React.useContext(FacultyListContext);

export const FacultyListProvider = (
    {children,
    }: {
    children: React.ReactNode;
}) => {

    const [state,dispatch] = useReducer(facultyListReducer, initialFacultyListState);

    const getFacultyList = () => {
        return new Promise<void>((resolve, reject) => {
            dispatch({ type: "SET_LOADING", payload: true });
            Backend.FacultyList.list()
                .then((response: AxiosResponse) => {
                    dispatch({ type: "SET_FACULTY_LIST", payload: response.data });
                    resolve();
                })
                .catch((error: AxiosError) => reject(error))
                .finally(() => dispatch({ type: "SET_LOADING", payload: false }));
        });
    };

    const updateFacultyList = (data: FacultyDTO) => {
        return new Promise<void>((resolve,reject)=>{
            dispatch({ type: "SET_LOADING", payload: true });
            Backend.FacultyList.update(data)
                .then((response: AxiosResponse) => {
                    resolve();
                })
                .catch((error: AxiosError) => reject(error))
                .finally(() => dispatch({ type: "SET_LOADING", payload: false }));
        })
    };

    return (
        <FacultyListContext.Provider
            value={{
                state,
                dispatch,
                getFacultyList,
                updateFacultyList,
            }}
        >
            {children}
        </FacultyListContext.Provider>
    );
};