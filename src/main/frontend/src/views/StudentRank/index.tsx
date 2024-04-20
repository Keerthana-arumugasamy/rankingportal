import React, { useState } from "react";
import { Button, Card, Col, Form, Input, Layout, PageHeader, Row, Space, Table } from "antd";
import { ColumnsType } from "antd/lib/table/interface";
import { AxiosError } from "axios";
import { StudentRankProvider, useStudentRankContext } from "./context";
import Page from "../../components/Page";
import Notify from "../../components/Notify";
import StudentDTO from "../../dtos/StudentDTO";

const StudentRankList = () => {
    const { state, dispatch, getStudentRank, updateStudentRank } = useStudentRankContext();
    const [selectedStudent, setSelectedStudent] = useState<StudentDTO>();
    const [form] = Form.useForm();

    const columns: ColumnsType<StudentDTO> = [
        {
            title: "Email",
            dataIndex: "email",
        },
        {
            title: "Name",
            dataIndex: "name",
        },
        {
            title: "Department",
            dataIndex: "department",
        },
        {
            title: "Roll Number",
            dataIndex: "rollno",
        },
        {
            title: "Marks",
            dataIndex: "marks",
        },
        {
            title: "Stack",
            dataIndex: "stack",
        },
        {
            title: "Project",
            dataIndex: "project",
        },
    ];

    React.useEffect(() => {
        fetchData();
        // eslint-disable-next-line
    }, []);

    const fetchData = () => {
        getStudentRank().catch((error: AxiosError) => {
            Notify({ type: "error", message: error.response?.data.message });
        });
    };

    const onFinish = (data: StudentDTO) => {
        if (selectedStudent) {
            // Assuming you have an `id` field in your StudentDTO
            data.id = selectedStudent.id;
            updateStudentRank(data).catch((error: AxiosError) => {
                Notify({ type: "error", message: error.response?.data.message });
            }).finally(fetchData);
        }
    };

    const onTableRowClick = (record: StudentDTO) => {
        setSelectedStudent(record);
        form.resetFields();
    };

    return (
        <Page title="Student Rank">
            <PageHeader title="Student Rank" />
            <Space direction="vertical" size={16} style={{ width: "100%" }}>
                <Table
                    size="middle"
                    scroll={{ x: "100vh" }}
                    dataSource={state.studentList}
                    columns={columns}
                    loading={state.loading}
                    rowKey={(record: StudentDTO) => record.id!}
                    onRow={(record) => ({
                        onClick: () => onTableRowClick(record),
                    })}
                />
            </Space>
            <Layout style={{ minHeight: "100vh" }}>
                <Layout.Content>
                    <Page title="Login">
                        <Row align="middle" style={{ minHeight: "100vh" }}>
                            <Col
                                xs={{ span: 24 }}
                                sm={{ span: 12, offset: 6 }}
                                lg={{ span: 10, offset: 7 }}
                                xl={{ span: 8, offset: 8 }}
                                xxl={{ span: 6, offset: 9 }}
                            >
                                <Card bordered className="auth-card">
                                    <span style={{ textAlign: "center", paddingBottom: "20px" }}>
                                        <h1>Update Student</h1>
                                    </span>
                                    <Form
                                        form={form}
                                        layout="vertical"
                                        onFinish={onFinish}
                                        autoComplete="off"
                                        initialValues={selectedStudent ? { ...selectedStudent } : {}}
                                    >
                                        <Form.Item
                                            name="email"
                                            label="Email"
                                            rules={[{ required: true, message: "Email is required" }]}
                                        >
                                            <Input allowClear placeholder="Email" />
                                        </Form.Item>
                                        <Form.Item
                                            name="marks"
                                            label="Marks"
                                            rules={[{ required: true, message: "Marks is required" }]}
                                        >
                                            <Input allowClear placeholder="Marks" />
                                        </Form.Item>
                                        <Form.Item
                                            name="stack"
                                            label="Stack"
                                            rules={[{ required: true, message: "Stack is required" }]}
                                        >
                                            <Input allowClear placeholder="Stack" />
                                        </Form.Item>
                                        <Form.Item
                                            name="project"
                                            label="Project"
                                            rules={[{ required: true, message: "Project is required" }]}
                                        >
                                            <Input allowClear placeholder="Project" />
                                        </Form.Item>
                                        <Row gutter={[24, 0]}>
                                            <Col span={12}>
                                                <Form.Item label=" ">
                                                    <Button htmlType="reset" block>
                                                        Reset
                                                    </Button>
                                                </Form.Item>
                                            </Col>
                                            <Col span={12}>
                                                <Form.Item label=" ">
                                                    <Button block type="primary" htmlType="submit">
                                                        Update Student
                                                    </Button>
                                                </Form.Item>
                                            </Col>
                                        </Row>
                                    </Form>
                                </Card>
                            </Col>
                        </Row>
                    </Page>
                </Layout.Content>
            </Layout>
        </Page>
    );
};

const StudentRankContainer = () => {
    return (
        <StudentRankProvider>
            <StudentRankList />
        </StudentRankProvider>
    );
};

export default StudentRankContainer;
