import React, {useState} from "react";
import {Button, Card, Col, Form, Input, Layout, PageHeader, Row, Space, Table} from "antd";
import {ColumnsType, TablePaginationConfig} from "antd/lib/table/interface";
import { AxiosError } from "axios";
import {AdminListProvider, useAdminListContext} from "./context";
import Page from "../../components/Page";
import Notify from "../../components/Notify";
import AdminDTO from "../../dtos/AdminDTO";

const AdminList = () => {
    const { state, dispatch, getAdminList} = useAdminListContext();
    const [selectedAdmin, setSelectedAdmin] = useState<AdminDTO>();

    const columns: ColumnsType<AdminDTO> = [
        {
            title: "Email",
            render: (record: AdminDTO) => record.email,
        },
        {
            title: "Name",
            render: (record: AdminDTO) => record.name,
        }

    ];

    React.useEffect(() => {
        fetchData();
        // eslint-disable-next-line
    }, []);


    const fetchData = () => {
        console.log("coming to fetch the data");
        getAdminList().catch((error: AxiosError) => {
            Notify({ type: "error", message: error.response?.data.message });
        });
    };

    return (
        <Page title="Admin">
            <PageHeader title="Admin" />
            <Space direction="vertical" size={16} style={{ width: "100%" }}>
                <Table
                    size="middle"
                    scroll={{ x: "100vh" }}
                    dataSource={state.adminList}
                    columns={columns}
                    loading={state.loading}
                    rowKey={(record: AdminDTO) => record.id!}
                />
            </Space>
        </Page>
    );
};

const AdminListContainer = () => {
    return (
        <AdminListProvider>
            <AdminList />
        </AdminListProvider>
    );
};
export default AdminListContainer;
