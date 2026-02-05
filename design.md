Mô tả: Hệ thống cần quản lý Task (Công việc) và User (Người dùng), mỗi công việc thuộc về một người dùng.

Nhiệm vụ: Viết file design.md thiết kế các Endpoint sau (đảm bảo dùng danh từ số nhiều, đúng Method):

1 Lấy toàn bộ danh sách công việc, người dùng.
GET /api/tasks
GET /api/users

2 Tạo mới công việc, tạo mới người dùng.
POST /api/tasks
POST /api/users
3 Cập nhật trạng thái một công việc, cập nhật vai trò của người dùng.
PATCH /api/tasks/{id}/status
PATCH /api/users/{id}/role

4 Xóa một công việc, xóa một người dùng khỏi hệ thống.
DELETE /api/tasks/{id}
DELETE /api/users/{id}

5 Tìm các công việc có mức độ ưu tiên là "high".
GET /api/tasks?priority=high

6 Tìm các công việc có độ ưu tiên là "high" và được giao cho người dùng với id là 1.
GET /api/users/1/tasks?priority=high

7 Liệt kê toàn bộ công việc của 1 người dùng.
GET /api/users/{id}/tasks

8 Gắn công việc cho người dùng.
PATCH /api/tasks/{taskId}/user
