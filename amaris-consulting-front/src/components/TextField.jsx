export default function TextField({ onChange }) {
    return (
        <input
            type="number"
            placeholder="Ingrese el ID del empleado"
            onChange={onChange} />
    );
}