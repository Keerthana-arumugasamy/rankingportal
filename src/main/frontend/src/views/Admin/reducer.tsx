import AdminDTO from "../../dtos/AdminDTO";

export type AdminListState = {
    adminList: AdminDTO[];
    loading: boolean;
};

export const initialAdminListState: AdminListState ={
    adminList : [],
    loading:true,
}

export type AdminListAction =
    | { type: "SET_ADMIN_LIST"; payload: AdminDTO[] }
    | { type: "SET_LOADING"; payload: boolean };

export const adminListReducer = (
    state: AdminListState,
    action: AdminListAction
) => {
    switch (action.type) {
        case "SET_ADMIN_LIST":
            return { ...state, adminList: action.payload };
        case "SET_LOADING":
            return { ...state, loading: action.payload };
        default:
            return state;
    }
};