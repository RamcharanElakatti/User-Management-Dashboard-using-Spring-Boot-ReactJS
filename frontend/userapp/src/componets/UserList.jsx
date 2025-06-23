import axios from "axios";
import { useEffect, useState } from "react";
import UserCard from './UserCard';
import UserModal from './UserModal';

function UserList() {
    const [users, setUsers] = useState([]);
    const [searchTerm, setSearchTerm] = useState("");
    const [selectedUser, setSelectedUser] = useState(null);
    const [showModal, setShowModal] = useState(false);

    useEffect(() => {
        loadUsers();
    }, []);

    const loadUsers = () => {
        axios.get('http://localhost:8080/api/users/')
            .then(res => setUsers(res.data))
            .catch(err => console.error("Error fetching users:", err));
    };

    const handleSearch = () => {
        if (!searchTerm.trim()) {
            loadUsers(); // Load all users if search is empty
            return;
        }

        axios.get(`http://localhost:8080/api/users/search?keyword=${searchTerm}`)
            .then(res => setUsers(res.data))
            .catch(err => console.error("Error searching users:", err));
    };

    const handleSort = (type) => {
        let sorted = [...users];
        if (type === "id") {
            sorted.sort((a, b) => a.id - b.id);
        } else if (type === "name") {
            sorted.sort((a, b) => a.firstName.localeCompare(b.firstName));
        } else if (type === "email") {
            sorted.sort((a, b) => a.email.localeCompare(b.email));
        }
        setUsers(sorted);
    };

    const openModal = (id) => {
        axios.get(`http://localhost:8080/api/users/${id}`)
            .then(res => {
                setSelectedUser(res.data);
                setShowModal(true);
            })
            .catch(err => console.error("User not found:", err));
    };

    return (
        <div className="container mt-4">
            <h3 className="mb-3">User Management</h3>

            <div className="mb-3 d-flex">
                <input
                    type="text"
                    className="form-control me-2"
                    placeholder="Search by name or email"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                />
                <button className="btn btn-primary" onClick={handleSearch}>Search</button>
            </div>

            <div className="mb-4">
                <button className="btn btn-outline-primary me-2" onClick={() => handleSort("id")}>Sort by ID</button>
                <button className="btn btn-outline-primary me-2" onClick={() => handleSort("name")}>Sort by Name</button>
                <button className="btn btn-outline-primary" onClick={() => handleSort("email")}>Sort by Email</button>
            </div>

            <div className="d-flex flex-wrap">
                {users.map((user) => (
                    <UserCard key={user.id} user={user} onClick={openModal} />
                ))}
            </div>

            <UserModal show={showModal} user={selectedUser} onClose={() => setShowModal(false)} />
        </div>
    );
}

export default UserList;
