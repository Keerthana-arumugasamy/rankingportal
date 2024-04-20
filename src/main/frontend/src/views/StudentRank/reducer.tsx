import StudentDTO from "../../dtos/StudentDTO";

export type StudentRankState = {
    studentList: StudentDTO[];
    loading: boolean;
};

export const initialStudentRankState: StudentRankState ={
    studentList : [],
    loading:true,
}

export type StudentRankAction =
    | { type: "SET_STUDENT_RANK"; payload: StudentDTO[] }
    | { type: "SET_LOADING"; payload: boolean };

export const studentRankReducer = (
    state: StudentRankState,
    action: StudentRankAction
) => {
    switch (action.type) {
        case "SET_STUDENT_RANK":
            return { ...state, studentList: action.payload };
        case "SET_LOADING":
            return { ...state, loading: action.payload };
        default:
            return state;
    }
};