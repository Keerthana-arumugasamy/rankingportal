import Backend from "../../config/Backend";
import { AxiosError, AxiosResponse } from "axios";
import React, {createContext, useReducer} from "react";
import {initialStudentRankState, StudentRankAction, studentRankReducer, StudentRankState} from "./reducer";
import StudentDTO from "../../dtos/StudentDTO";

const StudentRankContext = createContext<{
    state:StudentRankState;
    dispatch: React.Dispatch<StudentRankAction>;
    getStudentRank :() => Promise<void>;
    updateStudentRank:(data:StudentDTO) => Promise<void>;
    getStudentDetails:(data:StudentDTO) => Promise<void>;
}>(
    {
    state: initialStudentRankState,
    dispatch: () => null,
        getStudentRank: () => Promise.resolve(),
        updateStudentRank: () => Promise.resolve(),
        getStudentDetails:() => Promise.resolve(),
    }
);

export const useStudentRankContext = () => React.useContext(StudentRankContext);

export const StudentRankProvider = (
    {children,
    }: {
    children: React.ReactNode;
}) => {

    const [state,dispatch] = useReducer(studentRankReducer, initialStudentRankState);

    const getStudentRank = () => {
        return new Promise<void>((resolve, reject) => {
            dispatch({ type: "SET_LOADING", payload: true });
            Backend.StudentRank.list()
                .then((response: AxiosResponse) => {
                    dispatch({ type: "SET_STUDENT_RANK", payload: response.data });
                    resolve();
                })
                .catch((error: AxiosError) => reject(error))
                .finally(() => dispatch({ type: "SET_LOADING", payload: false }));
        });
    };

    const updateStudentRank = (data: StudentDTO) => {
        return new Promise<void>((resolve,reject)=>{
            dispatch({ type: "SET_LOADING", payload: true });
            Backend.StudentRank.update(data)
                .then((response: AxiosResponse) => {
                resolve();
                })
                .catch((error: AxiosError) => reject(error))
                .finally(() => dispatch({ type: "SET_LOADING", payload: false }));
        })
    };

    const getStudentDetails = (data: StudentDTO) => {
        return new Promise<void>((resolve,reject)=>{
            dispatch({ type: "SET_LOADING", payload: true });
            Backend.StudentRank.getDetails(data)
                .then((response: AxiosResponse) => {
                    dispatch({ type: "SET_STUDENT_DETAILS", payload: response.data });
                    resolve();
                })
                .catch((error: AxiosError) => reject(error))
                .finally(() => dispatch({ type: "SET_LOADING", payload: false }));
        })
    };

    return (
        <StudentRankContext.Provider
            value={{
                state,
                dispatch,
                getStudentRank,
                updateStudentRank,
                getStudentDetails,
            }}
        >
            {children}
        </StudentRankContext.Provider>
    );
};