const url_api=import.meta.env.VITE_API

const getEmployees = async () => {
    try {
        console.log(url_api);

        const response = await fetch(url_api);
        const jsonData = await response.json();
        console.log(jsonData.data);
        return jsonData.data;
    } catch (error) {
        console.error('Error fetching data:', error);
    }
};

const getEmployeeById = async (id) => {
    try {
        const response = await fetch(url_api + id);
        const jsonData = await response.json();
        let data = []
        data.push(jsonData.data)
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
    }
};

export {
    getEmployeeById,
    getEmployees
};