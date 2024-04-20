import FacultyDTO from "../../dtos/FacultyDTO";

export type FacultyListState = {
    facultyList: FacultyDTO[];
    loading: boolean;
};

export const initialFacultyListState: FacultyListState ={
    facultyList : [],
    loading:true,
}

export type FacultyListAction =
    | { type: "SET_FACULTY_LIST"; payload: FacultyDTO[] }
    | { type: "SET_LOADING"; payload: boolean };

export const facultyListReducer = (
    state: FacultyListState,
    action: FacultyListAction
) => {
    switch (action.type) {
        case "SET_FACULTY_LIST":
            return { ...state, facultyList: action.payload };
        case "SET_LOADING":
            return { ...state, loading: action.payload };
        default:
            return state;
    }
};